package com.example.myapplication.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    private static final String TABLE_NAME = "usuarios";
    private static final String api05 = "api05";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                "iddatabase TEXT," +
                "idempresa TEXT," +
                "idcosechalabor TEXT," +
                "descripcion TEXT," +
                "descripcion_corta TEXT," +
                "idcultivo TEXT," +
                "idactividad TEXT," +
                "idlabor TEXT," +
                "esrendimiento INTEGER," +
                "meta TEXT," +
                "costo TEXT," +
                "observaciones TEXT," +
                "activo INTEGER," +
                "fechacreacion TEXT" +
                ")");

        db.execSQL("CREATE TABLE "+api05 +"(" +
                "iddatabase TEXT," +
                "idempresa TEXT," +
                "idtrabajador TEXT," +
                "detalle TEXT," +
                "nombres TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }



}
