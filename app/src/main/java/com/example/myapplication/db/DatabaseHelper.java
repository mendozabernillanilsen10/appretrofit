package com.example.myapplication.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Trabajador;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    private static final String TABLE_NAME = "usuarios";

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    public void saveTrabajador(Trabajador trabajador) {
        SQLiteDatabase database = getWritableDatabase();
        database.insert("usuarios", null, trabajador.toValues());
        database.close();
    }

}
