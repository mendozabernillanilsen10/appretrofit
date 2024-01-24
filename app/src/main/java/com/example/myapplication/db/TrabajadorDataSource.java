package com.example.myapplication.db;


import android.content.Context;

import com.example.myapplication.model.Trabajador;

public class TrabajadorDataSource {
    private DatabaseHelper dbHelper;

    public TrabajadorDataSource(Context context) {
        dbHelper = new DatabaseHelper(context, "db", null, 1);
    }
    public void saveTrabajador(Trabajador trabajador) {
        dbHelper.saveTrabajador(trabajador);
    }
}