package com.example.myapplication.db;


import android.content.Context;

import com.example.myapplication.model.Trabajador;

public class TrabajadorDataSource {

    //intanciar DatabaseHelper y crear funcionn para abrir la base de datos
    private DatabaseHelper databaseHelper;

    public TrabajadorDataSource(Context context){
        databaseHelper = new DatabaseHelper(context);
    }
    public  void saveTrabajador(Trabajador trabajador){
        databaseHelper.saveTrabajador(trabajador);
    }
    public void open(){
        databaseHelper.getWritableDatabase();
    }
    public void close(){
        databaseHelper.close();
    }
}