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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class CompatibilidadActivity extends AppCompatActivity {
    private static String LOCAL = "";

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


    ImageView comp_img_aries = null;
    ImageView comp_img_tauro = null;
    ImageView comp_img_geminis = null;
    ImageView comp_img_cancer = null;
    ImageView comp_img_leo = null;
    ImageView comp_img_virgo = null;
    ImageView comp_img_libra = null;
    ImageView comp_img_escorpio = null;
    ImageView comp_img_sagitario = null;
    ImageView comp_img_capricornio = null;
    ImageView comp_img_acuario = null;
    ImageView comp_img_piscis = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compatibilidad);

        LOCAL = getApplicationContext().getFilesDir().getAbsolutePath() + "/";

        preferencias = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        id = preferencias.getInt("id", 1);

        toolbar = (Toolbar) findViewById(R.id.id_tb_toolbar);
        showToolbar(getResources().getString(R.string.scomp), true);

        Txt_Nombre_Signo_B = (TextView) this.findViewById(R.id.Txt_Nombre_Signo_Banner);
        Txt_Fechas_B = (TextView) this.findViewById(R.id.Txt_Fechas_Banner);
        ImgBanner = (ImageView) this.findViewById(R.id.ImgBanner);

        Txt_Nombre_Signo_B.setText(Utilidades.get_nombre_signo(this, id));
        Txt_Fechas_B.setText(Utilidades.get_fecha_signo(this, id));
        ImgBanner.setImageBitmap(Utilidades.get_imagen_signo(this, id, LOCAL));

        Txt_Signo1 = (TextView) this.findViewById(R.id.Txt_Signo1);
        Txt_Porcentaje = (TextView) this.findViewById(R.id.Txt_Porcentaje);
        Txt_Signo2 = (TextView) this.findViewById(R.id.Txt_Signo2);

        Txt_Signo1.setText(Utilidades.get_nombre_signo(this, id));
        Txt_Signo2.setText("---");

        comp_img_aries = (ImageView) this.findViewById(R.id.comp_img_aries);
        comp_img_tauro = (ImageView) this.findViewById(R.id.comp_img_tauro);
        comp_img_geminis = (ImageView) this.findViewById(R.id.comp_img_geminis);
        comp_img_cancer = (ImageView) this.findViewById(R.id.comp_img_cancer);
        comp_img_leo = (ImageView) this.findViewById(R.id.comp_img_leo);
        comp_img_virgo = (ImageView) this.findViewById(R.id.comp_img_virgo);
        comp_img_libra = (ImageView) this.findViewById(R.id.comp_img_libra);
        comp_img_escorpio = (ImageView) this.findViewById(R.id.comp_img_escorpio);
        comp_img_sagitario = (ImageView) this.findViewById(R.id.comp_img_sagitario);
        comp_img_capricornio = (ImageView) this.findViewById(R.id.comp_img_capricornio);
        comp_img_acuario = (ImageView) this.findViewById(R.id.comp_img_acuario);
        comp_img_piscis = (ImageView) this.findViewById(R.id.comp_img_piscis);

        comp_img_aries.setImageBitmap(Utilidades.get_imagen_signo(this, 1, LOCAL));
        comp_img_tauro.setImageBitmap(Utilidades.get_imagen_signo(this, 2, LOCAL));
        comp_img_geminis.setImageBitmap(Utilidades.get_imagen_signo(this, 3, LOCAL));
        comp_img_cancer.setImageBitmap(Utilidades.get_imagen_signo(this, 4, LOCAL));
        comp_img_leo.setImageBitmap(Utilidades.get_imagen_signo(this, 5, LOCAL));
        comp_img_virgo.setImageBitmap(Utilidades.get_imagen_signo(this, 6, LOCAL));
        comp_img_libra.setImageBitmap(Utilidades.get_imagen_signo(this, 7, LOCAL));
        comp_img_escorpio.setImageBitmap(Utilidades.get_imagen_signo(this, 8, LOCAL));
        comp_img_sagitario.setImageBitmap(Utilidades.get_imagen_signo(this, 9, LOCAL));
        comp_img_capricornio.setImageBitmap(Utilidades.get_imagen_signo(this, 10, LOCAL));
        comp_img_acuario.setImageBitmap(Utilidades.get_imagen_signo(this, 11, LOCAL));
        comp_img_piscis.setImageBitmap(Utilidades.get_imagen_signo(this, 12, LOCAL));
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

        CAFData data = CAFData.dataWithContentsOfFile(LOCAL + "/compatibilidad.json");
        if(data != null){
            try {
                JSONObject compatibilidadroot = new JSONObject(data.toText());

                String signo1=String.valueOf(id);
                String signo2=String.valueOf(idc);
                String compatibilidad = compatibilidadroot.getString(signo1 + "_" + signo2).toString();

                Txt_Signo1.setText(Utilidades.get_nombre_signo(this, id) + " " + getResources().getString(R.string.es));
                Txt_Porcentaje.setText(compatibilidad);
                Txt_Signo2.setText(getResources().getString(R.string.compatiblecon) + " " + Utilidades.get_nombre_signo(this, idc));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }





    }
}