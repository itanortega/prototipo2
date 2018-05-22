package com.sime.itanortegaortega.astross;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

    public static Drawable get_imagen_signo(Activity act, int id, String localpath) {

        Drawable res = act.getResources().getDrawable(R.drawable.aries);;
        switch (id){
            case 1:
                res =  act.getResources().getDrawable(R.drawable.aries);
                break;

            case 2:
                res =  act.getResources().getDrawable(R.drawable.tauro);
                break;

            case 3:
                res =  act.getResources().getDrawable(R.drawable.geminis);
                break;

            case 4:
                res =  act.getResources().getDrawable(R.drawable.cancer);
                break;

            case 5:
                res =  act.getResources().getDrawable(R.drawable.leo);
                break;

            case 6:
                res =  act.getResources().getDrawable(R.drawable.virgo);
                break;

            case 7:
                res =  act.getResources().getDrawable(R.drawable.libra);
                break;

            case 8:
                res =  act.getResources().getDrawable(R.drawable.escorpio);
                break;

            case 9:
                res =  act.getResources().getDrawable(R.drawable.sagitario);
                break;

            case 10:
                res =  act.getResources().getDrawable(R.drawable.capricornio);
                break;

            case 11:
                res =  act.getResources().getDrawable(R.drawable.acuario);
                break;

            case 12:
                res =  act.getResources().getDrawable(R.drawable.piscis);
                break;
        }

        /*CAFData data = CAFData.dataWithContentsOfFile(localPath + "/LastPhoto.jpg");
        if(data != null){
            Bitmap bitmap = data.toImage();
            if(bitmap != null){
                Img_Foto.setImageBitmap(bitmap);
            }
        }*/

        return res;
    }















    public static String get_elemento(Activity act, int id) {
        String res = "";
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.aries_elemento);
                break;

            case 2:
                res = act.getResources().getString(R.string.tauro_elemento);
                break;

            case 3:
                res = act.getResources().getString(R.string.geminis_elemento);
                break;

            case 4:
                res = act.getResources().getString(R.string.cancer_elemento);
                break;

            case 5:
                res = act.getResources().getString(R.string.leo_elemento);
                break;

            case 6:
                res = act.getResources().getString(R.string.virgo_elemento);
                break;

            case 7:
                res = act.getResources().getString(R.string.libra_elemento);
                break;

            case 8:
                res = act.getResources().getString(R.string.escorpio_elemento);
                break;

            case 9:
                res = act.getResources().getString(R.string.sagitario_elemento);
                break;

            case 10:
                res = act.getResources().getString(R.string.capricornio_elemento);
                break;

            case 11:
                res = act.getResources().getString(R.string.acuario_elemento);
                break;

            case 12:
                res = act.getResources().getString(R.string.piscis_elemento);
                break;
        }
        return res;
    }

    public static String get_descripcion(Activity act, int id) {
        String res = "";
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.aries_descripcion);
                break;

            case 2:
                res = act.getResources().getString(R.string.tauro_descripcion);
                break;

            case 3:
                res = act.getResources().getString(R.string.geminis_descripcion);
                break;

            case 4:
                res = act.getResources().getString(R.string.cancer_descripcion);
                break;

            case 5:
                res = act.getResources().getString(R.string.leo_descripcion);
                break;

            case 6:
                res = act.getResources().getString(R.string.virgo_descripcion);
                break;

            case 7:
                res = act.getResources().getString(R.string.libra_descripcion);
                break;

            case 8:
                res = act.getResources().getString(R.string.escorpio_descripcion);
                break;

            case 9:
                res = act.getResources().getString(R.string.sagitario_descripcion);
                break;

            case 10:
                res = act.getResources().getString(R.string.capricornio_descripcion);
                break;

            case 11:
                res = act.getResources().getString(R.string.acuario_descripcion);
                break;

            case 12:
                res = act.getResources().getString(R.string.piscis_descripcion);
                break;
        }
        return res;
    }

    public static String get_virtudes(Activity act, int id) {
        String res = "";
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.aries_cualidades);
                break;

            case 2:
                res = act.getResources().getString(R.string.tauro_cualidades);
                break;

            case 3:
                res = act.getResources().getString(R.string.geminis_cualidades);
                break;

            case 4:
                res = act.getResources().getString(R.string.cancer_cualidades);
                break;

            case 5:
                res = act.getResources().getString(R.string.leo_cualidades);
                break;

            case 6:
                res = act.getResources().getString(R.string.virgo_cualidades);
                break;

            case 7:
                res = act.getResources().getString(R.string.libra_cualidades);
                break;

            case 8:
                res = act.getResources().getString(R.string.escorpio_cualidades);
                break;

            case 9:
                res = act.getResources().getString(R.string.sagitario_cualidades);
                break;

            case 10:
                res = act.getResources().getString(R.string.capricornio_cualidades);
                break;

            case 11:
                res = act.getResources().getString(R.string.acuario_cualidades);
                break;

            case 12:
                res = act.getResources().getString(R.string.piscis_cualidades);
                break;
        }
        return res;
    }

    public static String get_defectos(Activity act, int id) {
        String res = "";
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.aries_defectos);
                break;

            case 2:
                res = act.getResources().getString(R.string.tauro_defectos);
                break;

            case 3:
                res = act.getResources().getString(R.string.geminis_defectos);
                break;

            case 4:
                res = act.getResources().getString(R.string.cancer_defectos);
                break;

            case 5:
                res = act.getResources().getString(R.string.leo_defectos);
                break;

            case 6:
                res = act.getResources().getString(R.string.virgo_defectos);
                break;

            case 7:
                res = act.getResources().getString(R.string.libra_defectos);
                break;

            case 8:
                res = act.getResources().getString(R.string.escorpio_defectos);
                break;

            case 9:
                res = act.getResources().getString(R.string.sagitario_defectos);
                break;

            case 10:
                res = act.getResources().getString(R.string.capricornio_defectos);
                break;

            case 11:
                res = act.getResources().getString(R.string.acuario_defectos);
                break;

            case 12:
                res = act.getResources().getString(R.string.piscis_defectos);
                break;
        }
        return res;
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

    public static String get_diario(Activity act, int id) {
        String res = "";
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.aries_diario);
                break;

            case 2:
                res = act.getResources().getString(R.string.tauro_diario);
                break;

            case 3:
                res = act.getResources().getString(R.string.geminis_diario);
                break;

            case 4:
                res = act.getResources().getString(R.string.cancer_diario);
                break;

            case 5:
                res = act.getResources().getString(R.string.leo_diario);
                break;

            case 6:
                res = act.getResources().getString(R.string.virgo_diario);
                break;

            case 7:
                res = act.getResources().getString(R.string.libra_diario);
                break;

            case 8:
                res = act.getResources().getString(R.string.escorpio_diario);
                break;

            case 9:
                res = act.getResources().getString(R.string.sagitario_diario);
                break;

            case 10:
                res = act.getResources().getString(R.string.capricornio_diario);
                break;

            case 11:
                res = act.getResources().getString(R.string.acuario_diario);
                break;

            case 12:
                res = act.getResources().getString(R.string.piscis_diario);
                break;
        }
        return res;
    }

    public static String get_semana(Activity act, int id) {
        String res = "";
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.aries_semana);
                break;

            case 2:
                res = act.getResources().getString(R.string.tauro_semana);
                break;

            case 3:
                res = act.getResources().getString(R.string.geminis_semana);
                break;

            case 4:
                res = act.getResources().getString(R.string.cancer_semana);
                break;

            case 5:
                res = act.getResources().getString(R.string.leo_semana);
                break;

            case 6:
                res = act.getResources().getString(R.string.virgo_semana);
                break;

            case 7:
                res = act.getResources().getString(R.string.libra_semana);
                break;

            case 8:
                res = act.getResources().getString(R.string.escorpio_semana);
                break;

            case 9:
                res = act.getResources().getString(R.string.sagitario_semana);
                break;

            case 10:
                res = act.getResources().getString(R.string.capricornio_semana);
                break;

            case 11:
                res = act.getResources().getString(R.string.acuario_semana);
                break;

            case 12:
                res = act.getResources().getString(R.string.piscis_semana);
                break;
        }
        return res;
    }

    public static String getPNL(Activity act, int id) {
        String res = "";
        switch (id){
            case 1:
                res =  act.getResources().getString(R.string.pnl1);
                break;

            case 2:
                res = act.getResources().getString(R.string.pnl2);
                break;

            case 3:
                res = act.getResources().getString(R.string.pnl3);
                break;

            case 4:
                res = act.getResources().getString(R.string.pnl4);
                break;

            case 5:
                res = act.getResources().getString(R.string.pnl5);
                break;

            case 6:
                res = act.getResources().getString(R.string.pnl6);
                break;

            case 7:
                res = act.getResources().getString(R.string.pnl7);
                break;

            case 8:
                res = act.getResources().getString(R.string.pnl8);
                break;

            case 9:
                res = act.getResources().getString(R.string.pnl9);
                break;

            case 10:
                res = act.getResources().getString(R.string.pnl10);
                break;

            case 11:
                res = act.getResources().getString(R.string.pnl11);
                break;

            case 12:
                res = act.getResources().getString(R.string.pnl12);
                break;
        }
        return res;
    }


    public static Drawable get_imagen_fondo(Activity act, int id) {
        Drawable res = act.getResources().getDrawable(R.drawable.aries_fondo);;
        switch (id){
            case 1:
                res =  act.getResources().getDrawable(R.drawable.aries_fondo);
                break;

            case 2:
                res =  act.getResources().getDrawable(R.drawable.tauro_fondo);
                break;

            case 3:
                res =  act.getResources().getDrawable(R.drawable.geminis_fondo);
                break;

            case 4:
                res =  act.getResources().getDrawable(R.drawable.cancer_fondo);
                break;

            case 5:
                res =  act.getResources().getDrawable(R.drawable.leo_fondo);
                break;

            case 6:
                res =  act.getResources().getDrawable(R.drawable.virgo_fondo);
                break;

            case 7:
                res =  act.getResources().getDrawable(R.drawable.libra_fondo);
                break;

            case 8:
                res =  act.getResources().getDrawable(R.drawable.escorpio_fondo);
                break;

            case 9:
                res =  act.getResources().getDrawable(R.drawable.sagitario_fondo);
                break;

            case 10:
                res =  act.getResources().getDrawable(R.drawable.capricornio_fondo);
                break;

            case 11:
                res =  act.getResources().getDrawable(R.drawable.acuario_fondo);
                break;

            case 12:
                res =  act.getResources().getDrawable(R.drawable.piscis_fondo);
                break;
        }
        return res;
    }
}
