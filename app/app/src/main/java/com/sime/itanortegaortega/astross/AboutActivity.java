package com.sime.itanortegaortega.astross;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {
    private static String LOCAL = "";

    Toolbar toolbar;
    ImageView signo_itan;
    ImageView signo_sonia;
    ImageView img_cesmag;
    ImageView img_caldas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        LOCAL = getApplicationContext().getFilesDir().getAbsolutePath() + "/";

        toolbar = (Toolbar) findViewById(R.id.id_tb_toolbar);
        showToolbar(getResources().getString(R.string.about), true);

        signo_itan = (ImageView) this.findViewById(R.id.signo_itan);
        signo_itan.setImageBitmap(Utilidades.get_imagen_signo(this, 1, LOCAL));

        signo_sonia = (ImageView) this.findViewById(R.id.signo_sonia);
        signo_sonia.setImageBitmap(Utilidades.get_imagen_signo(this, 11, LOCAL));

        img_cesmag = (ImageView) this.findViewById(R.id.img_cesmag);
        img_cesmag.setImageBitmap(Utilidades.get_imagen_signo(this, 13, LOCAL));

        img_caldas = (ImageView) this.findViewById(R.id.img_caldas);
        img_caldas.setImageBitmap(Utilidades.get_imagen_signo(this, 14, LOCAL));
    }

    public void showToolbar(String title, boolean upButton){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
