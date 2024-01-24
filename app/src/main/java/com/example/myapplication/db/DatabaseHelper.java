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

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (" +
                "idempresa TEXT," +
                "idtrabajador TEXT," +
                "nombresall TEXT," +
                "habilitado INTEGER," +
                "cnrodocumento TEXT UNIQUE," +
                "idplanilla TEXT," +
                "listanegra TEXT," +
                "liquidado TEXT," +
                "fecha_ingreso TEXT," +
                "fecha_cese TEXT," +
                "fecha_liquidado TEXT" +
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
