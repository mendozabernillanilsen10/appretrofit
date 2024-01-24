package com.example.myapplication.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Trabajador;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "nombre_de_tu_base_de_datos";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
        // Si quieres realizar una actualización más compleja, puedes hacerlo aquí
        // Por ejemplo, migrar datos de la versión anterior a la nueva
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    public void saveTrabajador(Trabajador trabajador) {
        SQLiteDatabase database = getWritableDatabase();
        database.insert("usuarios", null, trabajador.toValues());
        database.close();
    }

    // Resto del código...
}
