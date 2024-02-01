package com.example.library.jpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Map;
import java.util.Objects;


/**
 * Created by Asus on 24/12/2017.
 */

public class Pref {

    private Context prefContext;
    private SharedPreferences sharedPreferences;

    public Pref() {
    }

    public Pref(Context prefContext) {
        this.prefContext = prefContext;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.prefContext);
    }

    //<editor-fold defaultstate="collapsed" desc="Methods">

    public int getInt(String key) {
       // jmethods.infoLog(key + "\t<------------\t" + Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString(key, "1"))));
        return Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString(key, "1")));
    }

    public int getInt(String key, int defaultvalue) {
       // jmethods.infoLog(key + "\t<------------\t" + Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString(key, defaultvalue + ""))));
        return Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString(key, defaultvalue + "")));
    }

    public double getDouble(String key) {
       // jmethods.infoLog(key + "\t<------------\t" + Double.parseDouble(Objects.requireNonNull(sharedPreferences.getString(key, "1.0"))));
        return Double.parseDouble(Objects.requireNonNull(sharedPreferences.getString(key, "1.0")));
    }

    public String getString(String key) {
       // jmethods.infoLog(key + "\t<------------\t" + sharedPreferences.getString(key, "nothing"));
        return sharedPreferences.getString(key, "nothing");
    }

    public String getString(String key, String defaultValue) {
        //jmethods.infoLog(key + "\t<------------\t" + sharedPreferences.getString(key, defaultValue));
        return sharedPreferences.getString(key, defaultValue);
    }

    public boolean getBool(String key) {
       // jmethods.infoLog(key + "\t<------------\t" + (sharedPreferences.getBoolean(key, false) + ""));
        return sharedPreferences.getBoolean(key, false);
    }

    public boolean getBool(String key, boolean defaultvalue) {
        //jmethods.infoLog(key + "\t<------------\t" + (sharedPreferences.getBoolean(key, defaultvalue) + ""));
        return sharedPreferences.getBoolean(key, defaultvalue);
    }
    //----------------------------------------------------------------------------------------------


    /**
     * Set String for Preference
     *
     * @param key
     * @param v
     */
    public void setString(String key, String v) {
       // jmethods.infoLog(key + " ------------> " + v);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, v);
        editor.apply();
    }

    /**
     * Set Boolean for PreferenceF
     *
     * @param key
     * @param v
     */
    public void setBool(String key, boolean v) {
        //jmethods.infoLog(key + " ------------> " + v);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, v);
        editor.apply();
    }


    //</editor-fold>


    //<editor-fold defaultstate="collapsed" desc="Get & Set">

    public Context getPrefContext() {
        return prefContext;
    }

    public void setPrefContext(Context prefContext) {
        this.prefContext = prefContext;
    }

    //</editor-fold>

    public void printAL() {
        Map<String, ?> keys = sharedPreferences.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
          //  jmethods.imprimir(entry.getKey() + " : " + entry.getValue().toString());
        }
    }

}
