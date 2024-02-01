package com.example.myapplication.db;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.library.database.JSQLite;
import com.example.library.jother.jdir;
import com.example.library.jpreferences.Pref;
import com.example.myapplication.utils.others.files;


public class SQLite extends JSQLite {
    public SQLite(Context context) {
        super(context, jdir.pathPrincipal((AppCompatActivity) context)+ files.DIR_DB_FINAL, SQLiteHelper.versionDB);
            CONTEXT = context;
            try {
                sqliteHelper = new SQLiteHelper(CONTEXT);
            } catch (Exception ex) {

            }
            pref = new Pref(CONTEXT);
    }
}
