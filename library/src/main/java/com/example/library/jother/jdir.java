package com.example.library.jother;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

/**
 * Created by jmugi on 23/06/2017.
 */

public class jdir {
    public static void openFolder(AppCompatActivity activity, String path) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Uri uri = Uri.parse(path);
        intent.setDataAndType(uri, "text/csv");
        activity.startActivity(Intent.createChooser(intent, "Open folder"));
    }

    public static boolean dirExiste(AppCompatActivity activity, String path) {
        boolean ret = true;
        File file = new File(path);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                ret = false;
            }
        }
        return ret;
    }

    public static boolean dirExiste(String path) {
        return new File(path).exists();
    }

    public static String pathPrincipal(AppCompatActivity activity) {
        if (Build.VERSION.SDK_INT <= 29) {
            return Environment.getExternalStorageDirectory() + "/Android/Data/" + activity.getPackageName() + "/";
        } else {
            return activity.getExternalFilesDir(null).getPath() + "/";
        }
    }

    public static void dirSiNoExisteCrea(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
            folder.mkdir();
//            jmethods.infoLog("-------------------------------> Nuevo Directorio Creado: " + path);
        } else {
//            jmethods.infoLog("-------------------------------> El directorio " + path + " ya estaba creado.");
        }
    }

    public static void dirSiNoExisteCrea(AppCompatActivity activity, String path) {
        File folder = null;
        if (Build.VERSION.SDK_INT <= 29) {
            folder = new File(Environment.getExternalStorageDirectory() + "/Android/Data/" + activity.getPackageName() + "/", path);
        } else {
            folder = new File(activity.getExternalFilesDir(null), path);
        }
        if (!folder.exists()) {
            folder.mkdirs();
            //jmethods.infoLog("---> Nuevo Directorio Creado SD: " + folder.getAbsolutePath());
        } else {
           // jmethods.infoLog("---> Ya estaba Creado SD: " + folder.getAbsolutePath());

        }

    }

    public static void dirSiNoExisteCreaaa(String path) {
       // jmethods.imprimir("INTENTANDO CREAR ===========================>> " + path);
        File folder = new File(path);
        if (folder.mkdir()) {
            //jmethods.imprimir("CREADO = " + path);
        } else {
            //jmethods.imprimir("NO CREADO = " + path);
        }
    }

    public static void dirSiNoExisteCrea2(String path, int intSDK, boolean initial) {
        if (initial) {
            if (intSDK < 29) {
               // jmethods.imprimir("Version inferior a 29");
                //jmethods.imprimir("path.contains(files/) : " + path.contains("files/"));
                if (path.contains("files/")) {
                    String pathx = path.substring(0, path.indexOf("files/"));
                   // jmethods.imprimir("INTENTANDO CREAR sdk < 29 ===========================>> " + pathx);
                    File folderx = new File(pathx);
                    if (folderx.mkdir()) {
                        //jmethods.imprimir("CREADO = " + pathx);
                    } else {
                        //jmethods.imprimir("NO CREADO = " + pathx);
                    }
                }
            }

           // jmethods.imprimir("INTENTANDO CREAR ===========================>> " + path);
            File folder = new File(path);

            if (folder.mkdir()) {
                //jmethods.imprimir("CREADO = " + path);
            } else {
               // jmethods.imprimir("NO CREADO = " + path);
            }
        } else {

            //jmethods.imprimir("INTENTANDO CREAR ===========================>> " + path);
            File folder = new File(path);

            if (folder.mkdir()) {
               // jmethods.imprimir("CREADO = " + path);
            } else {
                //jmethods.imprimir("NO CREADO = " + path);
            }
        }


    }


}
