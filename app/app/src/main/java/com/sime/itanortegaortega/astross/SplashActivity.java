package com.sime.itanortegaortega.astross;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {

    private final static String DOMAIN = "http://181.62.161.249:41062/www/astross/";
    private static String LOCAL = "";
    private static String HOY = Utilidades.obtenerFecha();


    ProgressBar Pb_Estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Pb_Estado = (ProgressBar) findViewById(R.id.Pb_Estado);
        Pb_Estado.setMax(100);

        LOCAL = getApplicationContext().getFilesDir().getAbsolutePath() + "/";

        File file = new File(LOCAL + "iniciales.json"); file.delete();

        ExisteArchivosIniciales existeArchivoVersion = new ExisteArchivosIniciales();
        existeArchivoVersion.execute();

    }

    class ExisteArchivosIniciales extends AsyncTask<Void, Integer, Boolean> {

        private boolean existe = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {

            String urlLocal = LOCAL + "iniciales.json";
            URL urlL = null;
            boolean existe = false;

            CAFData data = CAFData.dataWithContentsOfFile(urlLocal);
            if(data != null){
                existe = true;
                for(int i=1; i<=80; i++){
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(i);
                }
            }

            return existe;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            Pb_Estado.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean existe) {
            super.onPostExecute(existe);

            if(existe){
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo != null){
                    DescargarArchivosHoy descargarArchivosHoy = new DescargarArchivosHoy();
                    descargarArchivosHoy.execute();
                }else {
                    Handler handler =  new Handler(getBaseContext().getMainLooper());
                    handler.post( new Runnable(){
                        public void run(){
                            Toast.makeText(getBaseContext(), "Es necesario conectarse a internet cuando se abre la aplicación por primera vez.", Toast.LENGTH_LONG).show();
                        }
                    });

                    Intent salida=new Intent( Intent.ACTION_MAIN);
                    finish();
                }
            }else{
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo != null){
                    DescargarArchivosBase descargarArchivos = new DescargarArchivosBase();
                    descargarArchivos.execute();
                }else {
                    Handler handler =  new Handler(getBaseContext().getMainLooper());
                    handler.post( new Runnable(){
                        public void run(){
                            Toast.makeText(getBaseContext(), "Es necesario conectarse a internet cuando se abre la aplicación por primera vez.", Toast.LENGTH_LONG).show();
                        }
                    });

                    Intent salida=new Intent( Intent.ACTION_MAIN);
                    finish();
                }
            }
        }
    }

    class DescargarArchivosBase extends AsyncTask<Void, Integer, Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean estadoEscritura = Utilidades.escribirArchivo(HOY, LOCAL + "fecha.dat");

            URL urlIniciales = null;
            try {
                urlIniciales = new URL(DOMAIN + "api.php?get=iniciales");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            CAFData inicialesData;

            if(urlIniciales != null) {
                inicialesData = CAFData.dataWithContentsOfURL(urlIniciales);
                try {
                    JSONObject inicialesJson = new JSONObject(inicialesData.toText());
                    inicialesData.writeToFile(LOCAL + "iniciales.json", true);
                    JSONArray archivosL = inicialesJson.getJSONArray("archivos");
                    JSONArray imagenesL = inicialesJson.getJSONArray("imágenes");

                    int cantidad = archivosL.length() + imagenesL.length();
                    int contador = 1;
                    CAFData data = null;

                    for (int i = 0; i < archivosL.length(); i++) {
                        try {
                            JSONObject archivo = archivosL.getJSONObject(i);
                            String nombre = archivo.getString("archivo").toString();
                            data = CAFData.dataWithContentsOfURL(new URL(DOMAIN + "api.php?get=" + nombre.substring(0, nombre.length()-5)));
                            data.writeToFile(LOCAL + nombre, true);
                            contador ++;
                            publishProgress(Integer.parseInt(String.valueOf(95*contador/cantidad))+1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }

                    for (int i = 0; i < imagenesL.length(); i++) {
                        try {
                            JSONObject archivo = imagenesL.getJSONObject(i);
                            String nombre = archivo.getString("archivo").toString();
                            data = CAFData.dataWithContentsOfURL(new URL(DOMAIN + "imgs/" + nombre));
                            data.writeToFile(LOCAL + nombre, true);
                            contador ++;
                            publishProgress(Integer.parseInt(String.valueOf(95*contador/cantidad))+1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            publishProgress(98);
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Pb_Estado.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null){
                DescargarArchivosHoy descargarArchivosHoy = new DescargarArchivosHoy();
                descargarArchivosHoy.execute();
            }else {
                Handler handler =  new Handler(getBaseContext().getMainLooper());
                handler.post( new Runnable(){
                    public void run(){
                        Toast.makeText(getBaseContext(), "Es necesario conectarse a internet cuando se abre la aplicación por primera vez.", Toast.LENGTH_LONG).show();
                    }
                });

                Intent salida=new Intent( Intent.ACTION_MAIN);
                finish();
            }

        }
    }

    class DescargarArchivosHoy extends AsyncTask<Void, Integer, Boolean>{

        String urlhoy = LOCAL + "fecha.dat";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            ArrayList<String> imagenes = new ArrayList<String>();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            URL urlHoy = null;
            try {
                urlHoy = new URL(urlhoy);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            CAFData ultimaActualizacionData;

            if(urlHoy != null) {
                boolean estadoEscritura = Utilidades.escribirArchivo(HOY, LOCAL + "fecha.dat");
            }else{
                CAFData fechalocal = CAFData.dataWithContentsOfFile(LOCAL + "fecha.dat");

                if(!fechalocal.toText().toString().equals(HOY)){
                    try {
                        CAFData horoscopoDiarioData = CAFData.dataWithContentsOfURL(new URL(DOMAIN + "api.php?get=" + HOY));
                        horoscopoDiarioData.writeToFile(LOCAL + "horoscopo.json", true);
                        boolean estadoEscritura = Utilidades.escribirArchivo(HOY, LOCAL + "fecha.dat");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }

            publishProgress(100);
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Pb_Estado.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            Pb_Estado.setProgress(100);
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
