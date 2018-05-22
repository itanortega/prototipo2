package com.sime.itanortegaortega.astross;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class NumerosActivity extends AppCompatActivity {

    SharedPreferences preferencias;
    Toolbar toolbar;
    int id;
    TextView Txt_Nombre_Signo_B = null;
    TextView Txt_Fechas_B = null;
    ImageView ImgBanner = null;
    TextView Txt_Numeros = null;
    TextView Txt_Chance = null;
    TextView Txt_Baloto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

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
        ImgBanner.setImageDrawable(Utilidades.get_imagen_signo(this, id));


        String numeros = String.valueOf((int) (Math.random() * 5)+1) + ", " + String.valueOf((int) (Math.random() * 8)+6) +" y " + String.valueOf((int) (Math.random() * 9)+7);
        String chance = String.valueOf((int) (Math.random() * 9999)+1000);
        String baloto = String.valueOf((int) (Math.random() * 999999)+100000);

        Txt_Numeros.setText(numeros);
        Txt_Chance.setText(chance);
        Txt_Baloto.setText(baloto);
    }

    public void showToolbar(String title, boolean upButton){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}