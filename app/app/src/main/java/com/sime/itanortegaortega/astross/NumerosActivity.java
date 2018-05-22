package com.sime.itanortegaortega.astross;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NumerosActivity extends AppCompatActivity {
    private static String LOCAL = "";

    SharedPreferences preferencias;
    Toolbar toolbar;
    int id;
    TextView Txt_Nombre_Signo_B = null;
    TextView Txt_Fechas_B = null;
    ImageView ImgBanner = null;
    TextView Txt_Numeros = null;
    TextView Txt_Chance = null;
    TextView Txt_Baloto = null;


    ImageView img_num = null;
    ImageView img_chance = null;
    ImageView img_baloto = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        LOCAL = getApplicationContext().getFilesDir().getAbsolutePath() + "/";

        preferencias = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        id = preferencias.getInt("id", 1);

        toolbar = (Toolbar) findViewById(R.id.id_tb_toolbar);
        showToolbar(getResources().getString(R.string.snum), true);

        Txt_Nombre_Signo_B = (TextView) this.findViewById(R.id.Txt_Nombre_Signo_Banner);
        Txt_Fechas_B = (TextView) this.findViewById(R.id.Txt_Fechas_Banner);
        ImgBanner = (ImageView) this.findViewById(R.id.ImgBanner);

        Txt_Numeros = (TextView) this.findViewById(R.id.Txt_Numeros);
        Txt_Chance = (TextView) this.findViewById(R.id.Txt_Chance);
        Txt_Baloto = (TextView) this.findViewById(R.id.Txt_Baloto);

        Txt_Nombre_Signo_B.setText(Utilidades.get_nombre_signo(this, id));
        Txt_Fechas_B.setText(Utilidades.get_fecha_signo(this, id));
        ImgBanner.setImageBitmap(Utilidades.get_imagen_signo(this, id, LOCAL));


        img_num = (ImageView) this.findViewById(R.id.img_num);
        img_num.setImageBitmap(Utilidades.get_imagen_signo(this, 16, LOCAL));

        img_chance = (ImageView) this.findViewById(R.id.img_chance);
        img_chance.setImageBitmap(Utilidades.get_imagen_signo(this, 17, LOCAL));

        img_baloto = (ImageView) this.findViewById(R.id.img_baloto);
        img_baloto.setImageBitmap(Utilidades.get_imagen_signo(this, 18, LOCAL));

        CAFData data = CAFData.dataWithContentsOfFile(LOCAL + "/horoscopo.json");
        if(data != null){
            try {
                JSONObject horoscoporoot = new JSONObject(data.toText());
                JSONArray horoscopo = horoscoporoot.getJSONArray("horoscopo");
                JSONObject datos_horoscopo = horoscopo.getJSONObject(id-1);
                String numeros = datos_horoscopo.getString("num").toString();
                String[] textos = numeros.split(";");
                Txt_Numeros.setText(textos[0]);
                Txt_Chance.setText(textos[1]);
                Txt_Baloto.setText(textos[2]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void showToolbar(String title, boolean upButton){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}