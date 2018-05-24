package com.sime.itanortegaortega.astross;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null){
            menu.getItem(0).setEnabled(false);
            menu.getItem(2).setEnabled(false);
            menu.getItem(4).setEnabled(false);
        }
        return true;
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

        CAFData data = CAFData.dataWithContentsOfFile(LOCAL + "/signos.json");
        if(data != null){
            try {
                JSONObject signoroot = new JSONObject(data.toText());
                JSONArray signo = signoroot.getJSONArray("signos");
                JSONObject datos_signo = signo.getJSONObject(id-1);

                String elemento;
                String descripcion;
                String virtudes;
                String defectos;

                if(this.getResources().getString(R.string.prefijo_idioma).equals("en")){
                    elemento = datos_signo.getString("elemento_en").toString();
                    descripcion = datos_signo.getString("descripcion_en").toString();
                    virtudes = datos_signo.getString("virtudes_en").toString();
                    defectos = datos_signo.getString("defectos_en").toString();
                }else{
                    elemento = datos_signo.getString("elemento_es").toString();
                    descripcion = datos_signo.getString("descripcion_es").toString();
                    virtudes = datos_signo.getString("virtudes_es").toString();
                    defectos = datos_signo.getString("defectos_es").toString();
                }

                Txt_Elemento_Signo.setText(elemento);
                Txt_Descripcion_Signo.setText(descripcion);
                Txt_Virtudes_Signo.setText(virtudes);
                Txt_Defectos_Signo.setText(defectos);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
