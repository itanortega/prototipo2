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

public class PnlActivity extends AppCompatActivity {
    private static String LOCAL = "";

    SharedPreferences preferencias;
    Toolbar toolbar;
    int id;
    TextView Txt_Nombre_Signo_B = null;
    TextView Txt_Fechas_B = null;
    ImageView ImgBanner = null;
    TextView Txt_frase1 = null;
    TextView Txt_frase2 = null;
    TextView Txt_frase3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnl);

        LOCAL = getApplicationContext().getFilesDir().getAbsolutePath() + "/";

        preferencias = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        id = preferencias.getInt("id", 1);

        toolbar = (Toolbar) findViewById(R.id.id_tb_toolbar);
        showToolbar(getResources().getString(R.string.spnl), true);

        Txt_Nombre_Signo_B = (TextView) this.findViewById(R.id.Txt_Nombre_Signo_Banner);
        Txt_Fechas_B = (TextView) this.findViewById(R.id.Txt_Fechas_Banner);
        ImgBanner = (ImageView) this.findViewById(R.id.ImgBanner);

        Txt_Nombre_Signo_B.setText(Utilidades.get_nombre_signo(this, id));
        Txt_Fechas_B.setText(Utilidades.get_fecha_signo(this, id));
        ImgBanner.setImageBitmap(Utilidades.get_imagen_signo(this, id, LOCAL));


        Txt_frase1 = (TextView) this.findViewById(R.id.Txt_frase1);
        Txt_frase2 = (TextView) this.findViewById(R.id.Txt_frase2);
        Txt_frase3 = (TextView) this.findViewById(R.id.Txt_frase3);

        CAFData data = CAFData.dataWithContentsOfFile(LOCAL + "/horoscopo.json");
        if(data != null){
            try {
                JSONObject horoscoporoot = new JSONObject(data.toText());
                JSONArray horoscopo = horoscoporoot.getJSONArray("horoscopo");
                JSONObject datos_horoscopo = horoscopo.getJSONObject(id-1);
                String numeros = datos_horoscopo.getString("pnl").toString();
                String[] textos = numeros.split(";");
                int i=1;
                if(this.getResources().getString(R.string.prefijo_idioma).equals("en")){
                    i = 0;
                }

                for(int j=i; j<textos.length;j+=2){
                    Txt_frase1.setText(textos[j]);
                }
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