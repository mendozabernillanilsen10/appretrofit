package com.example.myapplication;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.library.database.JSQLite;
import com.example.library.format.body.FormatMain;
import com.example.library.format.model.URL;
import com.example.library.jother.jdir;
import com.example.myapplication.db.SQLite;
import com.example.myapplication.url.ListaUrl;
import com.example.myapplication.utils.others.files;


import java.util.List;


public class MainActivity extends AppCompatActivity  {
    private TextView textView;

    private Button filledTonalButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView( ) {
        textView = findViewById(R.id.textView);
        filledTonalButton = findViewById(R.id.filledTonalButton);
        SQLite sqlite = new SQLite(this);
        sqlite.abrir();
        JSQLite jSQLite = new JSQLite(this, jdir.pathPrincipal((AppCompatActivity) this) + files.DIR_DB_FINAL, 206);
        jSQLite.abrir();
        List<URL> listaUrl = new ListaUrl().getListaUrl();
        FormatMain v1 = new FormatMain();
        v1.setListaUrl(listaUrl , jSQLite);
        String s= v1.proceso();
        //sqlite.cerrar();
    }

}


