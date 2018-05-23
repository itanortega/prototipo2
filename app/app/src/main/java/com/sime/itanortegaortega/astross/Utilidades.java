package com.sime.itanortegaortega.astross;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by itanortegaortega on 18/04/18.
 */

public class Utilidades {

    public static String obtenerFecha() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-05:00"), new Locale("es", "Colombia"));
        SimpleDateFormat DAT=new SimpleDateFormat("yyyy-MM-dd");
        return DAT.format(calendar.getTime());
    }

    public static boolean escribirArchivo(String texto, String ruta){
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            pw.println(texto);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    public static void redireccionar(AppCompatActivity act, MenuItem item, int i) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.iteDiario:
                intent = new Intent(act,DiarioActivity.class);
                intent.putExtra("id", i);
                act.startActivity(intent);
                break;
            case R.id.iteComp:
                intent = new Intent(act,CompatibilidadActivity.class);
                intent.putExtra("id", i);
                act.startActivity(intent);
                break;
            case R.id.iteNum:
                intent = new Intent(act,NumerosActivity.class);
                intent.putExtra("id", i);
                act.startActivity(intent);
                break;
            case R.id.iteFon:
                intent = new Intent(act,FondosActivity.class);
                intent.putExtra("id", i);
                act.startActivity(intent);
                break;
            case R.id.itePNL:
                intent = new Intent(act,PnlActivity.class);
                intent.putExtra("id", i);
                act.startActivity(intent);
                break;
            case R.id.iteAbout:
                intent = new Intent(act,AboutActivity.class);
                intent.putExtra("id", i);
                act.startActivity(intent);
                break;
        }
    }

    public static String get_nombre_signo(Activity act, int id) {
        String res;
        res = act.getResources().getString(R.string.aries);
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.aries);
                break;

            case 2:
                res = act.getResources().getString(R.string.tauro);
                break;

            case 3:
                res = act.getResources().getString(R.string.geminis);
                break;

            case 4:
                res = act.getResources().getString(R.string.cancer);
                break;

            case 5:
                res = act.getResources().getString(R.string.leo);
                break;

            case 6:
                res = act.getResources().getString(R.string.virgo);
                break;

            case 7:
                res = act.getResources().getString(R.string.libra);
                break;

            case 8:
                res = act.getResources().getString(R.string.escorpio);
                break;

            case 9:
                res = act.getResources().getString(R.string.sagitario);
                break;

            case 10:
                res = act.getResources().getString(R.string.capricornio);
                break;

            case 11:
                res = act.getResources().getString(R.string.acuario);
                break;

            case 12:
                res = act.getResources().getString(R.string.piscis);
                break;
        }
        return res;
    }

    public static String get_fecha_signo(Activity act, int id) {
        String res = "";
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.aries_f);
                break;

            case 2:
                res = act.getResources().getString(R.string.tauro_f);
                break;

            case 3:
                res = act.getResources().getString(R.string.geminis_f);
                break;

            case 4:
                res = act.getResources().getString(R.string.cancer_f);
                break;

            case 5:
                res = act.getResources().getString(R.string.leo_f);
                break;

            case 6:
                res = act.getResources().getString(R.string.virgo_f);
                break;

            case 7:
                res = act.getResources().getString(R.string.libra_f);
                break;

            case 8:
                res = act.getResources().getString(R.string.escorpio_f);
                break;

            case 9:
                res = act.getResources().getString(R.string.sagitario_f);
                break;

            case 10:
                res = act.getResources().getString(R.string.capricornio_f);
                break;

            case 11:
                res = act.getResources().getString(R.string.acuario_f);
                break;

            case 12:
                res = act.getResources().getString(R.string.piscis_f);
                break;
        }
        return res;
    }

    public static Bitmap get_imagen_signo(Activity act, int id, String localpath) {

        Bitmap respuesta = null;
        String res = "";
        switch (id){
            case 1:
                res =  "aries";
                break;

            case 2:
                res =  "tauro";
                break;

            case 3:
                res =  "geminis";
                break;

            case 4:
                res =  "cancer";
                break;

            case 5:
                res =  "leo";
                break;

            case 6:
                res =  "virgo";
                break;

            case 7:
                res =  "libra";
                break;

            case 8:
                res =  "escorpio";
                break;

            case 9:
                res =  "sagitario";
                break;

            case 10:
                res =  "capricornio";
                break;

            case 11:
                res =  "acuario";
                break;

            case 12:
                res =  "piscis";
                break;

            case 13:
                res =  "iucesmag";
                break;

            case 14:
                res =  "caldas";
                break;

            case 15:
                res =  "circulofnd";
                break;

            case 16:
                res =  "num";
                break;

            case 17:
                res =  "chance";
                break;

            case 18:
                res =  "baloto";
                break;
        }

        CAFData data = CAFData.dataWithContentsOfFile(localpath + "/" + res + ".png");
        if(data != null){
            respuesta = data.toImage();
        }

        return respuesta;
    }




    public static Bitmap get_imagen_fondo(Activity act, int id, String localpath) {
        Bitmap respuesta = null;
        String res = "";
        switch (id){
            case 1:
                res =  "aries";
                break;

            case 2:
                res =  "tauro";
                break;

            case 3:
                res =  "geminis";
                break;

            case 4:
                res =  "cancer";
                break;

            case 5:
                res =  "leo";
                break;

            case 6:
                res =  "virgo";
                break;

            case 7:
                res =  "libra";
                break;

            case 8:
                res =  "escorpio";
                break;

            case 9:
                res =  "sagitario";
                break;

            case 10:
                res =  "capricornio";
                break;

            case 11:
                res =  "acuario";
                break;

            case 12:
                res =  "piscis";
                break;
        }

        CAFData data = CAFData.dataWithContentsOfFile(localpath + "/" + res + "_fondo.png");
        if(data != null){
            respuesta = data.toImage();
        }

        return respuesta;
    }

    public static String get_mes(Activity act, int id) {
        String res = "";
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.enero);
                break;

            case 2:
                res = act.getResources().getString(R.string.febrero);
                break;

            case 3:
                res = act.getResources().getString(R.string.marzo);
                break;

            case 4:
                res = act.getResources().getString(R.string.abril);
                break;

            case 5:
                res = act.getResources().getString(R.string.mayo);
                break;

            case 6:
                res = act.getResources().getString(R.string.junio);
                break;

            case 7:
                res = act.getResources().getString(R.string.julio);
                break;

            case 8:
                res = act.getResources().getString(R.string.agosto);
                break;

            case 9:
                res = act.getResources().getString(R.string.septiembre);
                break;

            case 10:
                res = act.getResources().getString(R.string.octubre);
                break;

            case 11:
                res = act.getResources().getString(R.string.noviembre);
                break;

            case 12:
                res = act.getResources().getString(R.string.diciembre);
                break;
        }
        return res;
    }

    public static String get_prefijo(int id){
        String res = "";
        switch (id){
            case 1:
                res = "aries";
                break;
            case 2:
                res = "tauro";
                break;
            case 3:
                res = "geminis";
                break;
            case 4:
                res = "cancer";
                break;
            case 5:
                res = "leo";
                break;
            case 6:
                res = "virgo";
                break;
            case 7:
                res = "libra";
                break;
            case 8:
                res = "escorpio";
                break;
            case 9:
                res = "sagitario";
                break;
            case 10:
                res = "capricornio";
                break;
            case 11:
                res = "acuario";
                break;
            case 12:
                res = "piscis";
                break;
        }
        return res;
    }
}
