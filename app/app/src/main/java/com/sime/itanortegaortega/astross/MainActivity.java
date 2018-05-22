package com.sime.itanortegaortega.astross;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String LOCAL = "";
    SharedPreferences preferencias;

    TextView Txt_Nombre_Signo = null;
    TextView Txt_Fechas = null;
    ImageView ImgVCentral = null;
    ImageView main_img_aries = null;
    ImageView main_img_tauro = null;
    ImageView main_img_geminis = null;
    ImageView main_img_cancer = null;
    ImageView main_img_leo = null;
    ImageView main_img_virgo = null;
    ImageView main_img_libra = null;
    ImageView main_img_escorpio = null;
    ImageView main_img_sagitario = null;
    ImageView main_img_capricornio = null;
    ImageView main_img_acuario = null;
    ImageView main_img_piscis = null;
    ImageView img_aro_dorado = null;

    int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LOCAL = getApplicationContext().getFilesDir().getAbsolutePath() + "/";

        Txt_Nombre_Signo = (TextView) this.findViewById(R.id.Txt_Nombre_Signo);
        Txt_Fechas = (TextView) this.findViewById(R.id.Txt_Fechas);
        ImgVCentral = (ImageView) this.findViewById(R.id.ImgVCentral);

        main_img_aries = (ImageView) this.findViewById(R.id.main_img_aries);
        main_img_tauro = (ImageView) this.findViewById(R.id.main_img_tauro);
        main_img_geminis = (ImageView) this.findViewById(R.id.main_img_geminis);
        main_img_cancer = (ImageView) this.findViewById(R.id.main_img_cancer);
        main_img_leo = (ImageView) this.findViewById(R.id.main_img_leo);
        main_img_virgo = (ImageView) this.findViewById(R.id.main_img_virgo);
        main_img_libra = (ImageView) this.findViewById(R.id.main_img_libra);
        main_img_escorpio = (ImageView) this.findViewById(R.id.main_img_escorpio);
        main_img_sagitario = (ImageView) this.findViewById(R.id.main_img_sagitario);
        main_img_capricornio = (ImageView) this.findViewById(R.id.main_img_capricornio);
        main_img_acuario = (ImageView) this.findViewById(R.id.main_img_acuario);
        main_img_piscis = (ImageView) this.findViewById(R.id.main_img_piscis);

        main_img_aries.setImageBitmap(Utilidades.get_imagen_signo(this, 1, LOCAL));
        main_img_tauro.setImageBitmap(Utilidades.get_imagen_signo(this, 2, LOCAL));
        main_img_geminis.setImageBitmap(Utilidades.get_imagen_signo(this, 3, LOCAL));
        main_img_cancer.setImageBitmap(Utilidades.get_imagen_signo(this, 4, LOCAL));
        main_img_leo.setImageBitmap(Utilidades.get_imagen_signo(this, 5, LOCAL));
        main_img_virgo.setImageBitmap(Utilidades.get_imagen_signo(this, 6, LOCAL));
        main_img_libra.setImageBitmap(Utilidades.get_imagen_signo(this, 7, LOCAL));
        main_img_escorpio.setImageBitmap(Utilidades.get_imagen_signo(this, 8, LOCAL));
        main_img_sagitario.setImageBitmap(Utilidades.get_imagen_signo(this, 9, LOCAL));
        main_img_capricornio.setImageBitmap(Utilidades.get_imagen_signo(this, 10, LOCAL));
        main_img_acuario.setImageBitmap(Utilidades.get_imagen_signo(this, 11, LOCAL));
        main_img_piscis.setImageBitmap(Utilidades.get_imagen_signo(this, 12, LOCAL));


        img_aro_dorado = (ImageView) this.findViewById(R.id.img_aro_dorado);
        img_aro_dorado.setImageBitmap(Utilidades.get_imagen_signo(this, 15, LOCAL));

        preferencias = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        id = preferencias.getInt("id", 1);
        cambiarCentro(preferencias.getInt("id", 1));

        cambiarCentro(id);
    }

    private int obtenerGrados(int id) {
        int grados = (id-1)*30;
        return grados;
    }

    public void setAries(View view) {
        cambiarCentro(1);
    }

    public void setTauro(View view) {
        cambiarCentro(2);
    }

    public void setGeminis(View view) {
        cambiarCentro(3);
    }

    public void setCancer(View view) {
        cambiarCentro(4);
    }

    public void setLeo(View view) {
        cambiarCentro(5);
    }

    public void setVirgo(View view) {
        cambiarCentro(6);
    }

    public void setLibra(View view) {
        cambiarCentro(7);
    }

    public void setEscorpio(View view) {
        cambiarCentro(8);
    }

    public void setSagitario(View view) {
        cambiarCentro(9);
    }

    public void setCapricornio(View view) {
        cambiarCentro(10);
    }

    public void setAcuario(View view) {
        cambiarCentro(11);
    }

    public void setPiscis(View view) {
        cambiarCentro(12);
    }

    private void cambiarCentro(int i) {
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putInt("id", i);
        editor.commit();

        Txt_Nombre_Signo.setText(Utilidades.get_nombre_signo(this, i));
        Txt_Fechas.setText(Utilidades.get_fecha_signo(this, i));
        ImgVCentral.setImageBitmap(Utilidades.get_imagen_signo(this, i, LOCAL));
    }

    public void toSigno(View view) {
        Intent intent = new Intent(this, SignoActivity.class);
        startActivity(intent);
    }
}
