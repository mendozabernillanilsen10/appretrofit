package com.example.library.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by KevinLeandro on 19/10/2015.
 */

public class JSQLiteHelper extends SQLiteOpenHelper {

    private Context context;
    public JSQLiteHelper(Context context, String dirBD, int verBD) {
        super(context, dirBD, null, verBD);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {

    }
}




