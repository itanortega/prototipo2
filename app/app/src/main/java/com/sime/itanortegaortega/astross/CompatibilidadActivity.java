package com.sime.itanortegaortega.astross;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CompatibilidadActivity extends AppCompatActivity {

    SharedPreferences preferencias;
    Toolbar toolbar;
    int id;
    int idc;
    TextView Txt_Nombre_Signo_B = null;
    TextView Txt_Fechas_B = null;
    ImageView ImgBanner = null;
    TextView Txt_Signo1;
    TextView Txt_Porcentaje;
    TextView Txt_Signo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compatibilidad);

        preferencias = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        id = preferencias.getInt("id", 1);

        toolbar = (Toolbar) findViewById(R.id.id_tb_toolbar);
        showToolbar(getResources().getString(R.string.scomp), true);

        Txt_Nombre_Signo_B = (TextView) this.findViewById(R.id.Txt_Nombre_Signo_Banner);
        Txt_Fechas_B = (TextView) this.findViewById(R.id.Txt_Fechas_Banner);
        ImgBanner = (ImageView) this.findViewById(R.id.ImgBanner);

        Txt_Nombre_Signo_B.setText(Utilidades.get_nombre_signo(this, id));
        Txt_Fechas_B.setText(Utilidades.get_fecha_signo(this, id));
        ImgBanner.setImageDrawable(Utilidades.get_imagen_signo(this, id));

        Txt_Signo1 = (TextView) this.findViewById(R.id.Txt_Signo1);
        Txt_Porcentaje = (TextView) this.findViewById(R.id.Txt_Porcentaje);
        Txt_Signo2 = (TextView) this.findViewById(R.id.Txt_Signo2);

        Txt_Signo1.setText(Utilidades.get_nombre_signo(this, id));
        Txt_Signo2.setText("---");
    }



    public void showToolbar(String title, boolean upButton){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void setAries(View view) {
        calcular(1);
    }

    public void setTauro(View view) {
        calcular(2);
    }

    public void setGeminis(View view) {
        calcular(3);
    }

    public void setCancer(View view) {
        calcular(4);
    }

    public void setLeo(View view) {
        calcular(5);
    }

    public void setVirgo(View view) {
        calcular(6);
    }

    public void setLibra(View view) {
        calcular(7);
    }

    public void setEscorpio(View view) {
        calcular(8);
    }

    public void setSagitario(View view) {
        calcular(9);
    }

    public void setCapricornio(View view) {
        calcular(10);
    }

    public void setAcuario(View view) {
        calcular(11);
    }

    public void setPiscis(View view) {
        calcular(12);
    }

    public void calcular(int b) {
        idc = b;
        int compatibilidad = (int) (Math.random() * 100);
        Txt_Signo1.setText(Utilidades.get_nombre_signo(this, id) + " " + getResources().getString(R.string.es));
        for(int i=0; i<=compatibilidad; i++){
            Txt_Porcentaje.setText(String.valueOf(i) + "%");
            Txt_Signo2.setText(getResources().getString(R.string.compatiblecon) + " " + Utilidades.get_nombre_signo(this, idc));
        }
    }
}