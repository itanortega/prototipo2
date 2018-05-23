package com.sime.itanortegaortega.astross;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class DiarioActivity extends AppCompatActivity {
    private static String LOCAL = "";

    SharedPreferences preferencias;
    Toolbar toolbar;
    int id;
    TextView Txt_Nombre_Signo_B = null;
    TextView Txt_Fechas_B = null;
    ImageView ImgBanner = null;
    TextView Txt_FechaHoy;
    TextView Txt_Diario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario);

        LOCAL = getApplicationContext().getFilesDir().getAbsolutePath() + "/";

        preferencias = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        id = preferencias.getInt("id", 1);

        toolbar = (Toolbar) findViewById(R.id.id_tb_toolbar);
        showToolbar(getResources().getString(R.string.sdiario), true);


        Txt_Nombre_Signo_B = (TextView) this.findViewById(R.id.Txt_Nombre_Signo_Banner);
        Txt_Fechas_B = (TextView) this.findViewById(R.id.Txt_Fechas_Banner);
        ImgBanner = (ImageView) this.findViewById(R.id.ImgBanner);

        Txt_Nombre_Signo_B.setText(Utilidades.get_nombre_signo(this, id));
        Txt_Fechas_B.setText(Utilidades.get_fecha_signo(this, id));
        ImgBanner.setImageBitmap(Utilidades.get_imagen_signo(this, id, LOCAL));

        Txt_FechaHoy = (TextView) this.findViewById(R.id.Txt_FechaHoy);
        Txt_Diario = (TextView) this.findViewById(R.id.Txt_Diario);

        Calendar c = Calendar.getInstance();
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String annio = Integer.toString(c.get(Calendar.YEAR));

        Txt_FechaHoy.setText(getResources().getString(R.string.horoscopodel) + " " + dia + " " + getResources().getString(R.string.de) + " " + Utilidades.get_mes(this, Integer.parseInt(mes)) + " " + getResources().getString(R.string.del) + " " + annio);

        CAFData data = CAFData.dataWithContentsOfFile(LOCAL + "/horoscopo.json");
        if(data != null){
            try {
                JSONObject horoscoporoot = new JSONObject(data.toText());
                JSONArray horoscopo = horoscoporoot.getJSONArray("horoscopo");
                JSONObject datos_horoscopo = horoscopo.getJSONObject(id-1);

                String diario;
                if(this.getResources().getString(R.string.prefijo_idioma).equals("en")){
                    diario = datos_horoscopo.getString(Utilidades.get_prefijo(id) + "_en").toString();
                }else{
                    diario = datos_horoscopo.getString(Utilidades.get_prefijo(id) + "_es").toString();
                }

                Txt_Diario.setText(diario);
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