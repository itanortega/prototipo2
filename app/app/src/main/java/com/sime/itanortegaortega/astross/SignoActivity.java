package com.sime.itanortegaortega.astross;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class SignoActivity extends AppCompatActivity {
    private static String LOCAL = "";

    SharedPreferences preferencias;
    Toolbar toolbar;
    int id;
    TextView Txt_Nombre_Signo_B = null;
    TextView Txt_Fechas_B = null;
    ImageView ImgBanner = null;

    TextView Txt_Elemento_Signo = null;
    TextView Txt_Descripcion_Signo = null;
    TextView Txt_Virtudes_Signo = null;
    TextView Txt_Defectos_Signo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signo);

        LOCAL = getApplicationContext().getFilesDir().getAbsolutePath() + "/";

        preferencias = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        id = preferencias.getInt("id", 1);

        toolbar = (Toolbar) findViewById(R.id.id_tb_toolbar);
        showToolbar(Utilidades.get_nombre_signo(this, id), true);

        Txt_Nombre_Signo_B = (TextView) this.findViewById(R.id.Txt_Nombre_Signo_Banner);
        Txt_Fechas_B = (TextView) this.findViewById(R.id.Txt_Fechas_Banner);
        ImgBanner = (ImageView) this.findViewById(R.id.ImgBanner);

        Txt_Elemento_Signo = (TextView) this.findViewById(R.id.Txt_Elemento_Signo);
        Txt_Descripcion_Signo = (TextView) this.findViewById(R.id.Txt_Descripcion_Signo);
        Txt_Virtudes_Signo = (TextView) this.findViewById(R.id.Txt_Virtudes_Signo);
        Txt_Defectos_Signo = (TextView) this.findViewById(R.id.Txt_Defectos_Signo);

        cambiarDatos();
    }

    public void showToolbar(String title, boolean upButton){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Utilidades.redireccionar(this, item, 1);
        return super.onOptionsItemSelected(item);
    }

    private void cambiarDatos() {
        Txt_Nombre_Signo_B.setText(Utilidades.get_nombre_signo(this, id));
        Txt_Fechas_B.setText(Utilidades.get_fecha_signo(this, id));
        ImgBanner.setImageBitmap(Utilidades.get_imagen_signo(this, id, LOCAL));

        Txt_Elemento_Signo.setText(Utilidades.get_elemento(this, id));
        Txt_Descripcion_Signo.setText(Utilidades.get_descripcion(this, id));
        Txt_Virtudes_Signo.setText(Utilidades.get_virtudes(this, id));
        Txt_Defectos_Signo.setText(Utilidades.get_defectos(this, id));
    }
}
