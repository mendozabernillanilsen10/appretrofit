package com.example.library.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.UrlQuerySanitizer;

import com.example.library.exection.GeneralServiceException;
import com.example.library.jpreferences.Pref;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JSQLite {
    UrlQuerySanitizer jmethods;
    public Context CONTEXT;
    public JSQLiteHelper sqliteHelper;
    public SQLiteDatabase db;
    public boolean OPEN = false, ENCRIPT = false;
    public String fileLog;
    public Pref pref;

    public UrlQuerySanitizer getJmethods() {
        return jmethods;
    }

    public void setJmethods(UrlQuerySanitizer jmethods) {
        this.jmethods = jmethods;
    }

    public Context getCONTEXT() {
        return CONTEXT;
    }

    public void setCONTEXT(Context CONTEXT) {
        this.CONTEXT = CONTEXT;
    }

    public JSQLiteHelper getSqliteHelper() {
        return sqliteHelper;
    }

    public void setSqliteHelper(JSQLiteHelper sqliteHelper) {
        this.sqliteHelper = sqliteHelper;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

    public String getFileLog() {
        return fileLog;
    }

    public void setFileLog(String fileLog) {
        this.fileLog = fileLog;
    }

    public Pref getPref() {
        return pref;
    }

    public void setPref(Pref pref) {
        this.pref = pref;
    }

    public String getInsertLogEstado() {
        return insertLogEstado;
    }

    public void setInsertLogEstado(String insertLogEstado) {
        this.insertLogEstado = insertLogEstado;
    }

    public String insertLogEstado = "\"INSERT INTO logestado (iddatabase, idempresa, idreferencia, tablareferencia, valor_anterior, valor_nuevo, idusuario,observaciones) VALUES (?1, ?2, ?3, 'SINC_TRABAJADOR', ?4, ?5, ?6, ?7);";

    public JSQLite(Context context, String dirBD, int verBD) {
        sqliteHelper = new JSQLiteHelper(context, dirBD, verBD);
        CONTEXT = context;
    }

    public JSQLite(Context context, String dirBD, int verBD, String fileLog) {
        sqliteHelper = new JSQLiteHelper(context, dirBD, verBD);
        CONTEXT = context;
        this.fileLog = fileLog;
    }


    public void abrir() {
        OPEN = true;
        db = sqliteHelper.getWritableDatabase();
    }

    public void cerrar() {
        OPEN = false;
        sqliteHelper.close();
       // jmethods.infoLog("@@@@@ Close BD: " + sqliteHelper.getDatabaseName() + " | " + CONTEXT.getClass().getSimpleName() + " / " + getClass().getName());
    }

    /**
     * Calcular un Entero, por medio de un Query Directo
     *
     * @param consulta Consulta Query
     * @return
     */
    public int get_int(String consulta) {
        int r = 0;
        Cursor c = db.rawQuery(consulta, null);
        try {
            if (c.moveToFirst()) {
                do {
                    r = c.getInt(0);
                } while (c.moveToNext());
            }
        } catch (SQLiteException e) {
            showException(e);
        } finally {
            assert c != null;
            c.close();
        }
        //imprimirSL(3);
       // imprimir("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        /*imprimir("int get_int(String consulta)");
        imprimir(consulta);
        imprimir("R = " + r);
        imprimir("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        imprimirSL(3);
        */
        return r;
    }



    public boolean isENCRIPT() {
        return ENCRIPT;
    }

    public void setENCRIPT(boolean ENCRIPT) {
        this.ENCRIPT = ENCRIPT;
    }

    public boolean isOPEN() {
        return OPEN;
    }

    public void setOPEN(boolean OPEN) {
        this.OPEN = OPEN;
    }

    public void borrarTabla(String tabla) {
        try {
            //imprimir("\nborrarTabla(String tabla)\n" + "T = " + "delete from " + tabla + ";" + "\n" + "R = " + tabla + "\n \n");
            db.execSQL("delete from " + tabla + ";");
        } catch (SQLiteException e) {
            showException(e);
        }
    }

    public int borrarTablaInt(String tabla) {
        return db.delete(tabla, null, null);
    }

    public void exec_query(String consulta) {
        try {
            //imprimir("\n \n \nexec_query(String consulta)\n" + "E = " + consulta + "\n \n \n");
            db.execSQL(consulta);
        } catch (SQLiteException e) {
            showException(e);
        }
    }

    public void exec_query(String consulta, boolean encripted, Object... data) {
        try {
            consulta = parseQuery(consulta, encripted, data);
           // imprimir("\nexec_query(String consulta)\n" + "E = " + consulta + "\n \n");
            db.execSQL(consulta);
        } catch (SQLiteException e) {
            showException(e);
        }
    }

    public String getTableNames() {
        StringBuilder tableNamesBuilder = new StringBuilder();
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        // Retrieve table name from the cursor
                        String tableName = cursor.getString(0);

                        // Append the table name to the StringBuilder
                        tableNamesBuilder.append(tableName).append(", ");
                    } while (cursor.moveToNext());
                }
            } finally {
                // Close the cursor to avoid resource leaks
                cursor.close();
            }
        }


        // Remove the trailing comma and space
        int length = tableNamesBuilder.length();
        if (length > 2) {
            tableNamesBuilder.setLength(length - 2);
        }

        return tableNamesBuilder.toString();
    }














    private String parseQuery(String consulta, boolean encripted, Object[] data) {

    return consulta;
    }


    private void showException(Exception e) {
      //  imprimir(e.getMessage());
        //String problem = jdate.getFechaHora(5) + "\nSe ha encontrado una Observacion:\n" + CONTEXT.getClass().getCanonicalName() + "\n" + "ST" + "Message: " + e.getMessage() + "\n\n" + "Cause: " + e.getCause() + "\n\n" + "LocalMessage: " + e.getLocalizedMessage() + "\n\n" + "Stack: " + Arrays.toString(e.getStackTrace()) + "\n\n" + "Final: " + e.toString() + "\n\n\n";
     //   jdialog.DialogSimple(CONTEXT, "Mensaje de Problema", problem);
      //  printFileLog(fileLog, problem);
    }

















    public int insertarRegistro(String tabla, String[] cabeceras, String... values) {

        int r = 0;
        try {
            db.beginTransaction();
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < cabeceras.length; i++)
                contentValues.put(cabeceras[i], values[i]);

            r = Integer.parseInt(db.insert(tabla, null, contentValues) + "");
            pref.setBool("generaltareo_existenMovimientos", false);
            db.setTransactionSuccessful();
            db.endTransaction();
        } catch (SQLiteException e) {
            showException(e);
        }
        ///imprimir("\ninsertarRegistro(String tabla, String[] cabeceras, String... values)\n" + "T = " + tabla + "\n" + "C = " + Arrays.toString(cabeceras) + "\n" + "V = " + Arrays.toString(values) + "\n" + "R = " + r + "\n \n");
        return r;
    }




    public int insertarRegistro(String tabla, Map<String, Object> registro) {
        int r = 0;

        try {
            db.beginTransaction();
            ContentValues contentValues = new ContentValues();

            for (Map.Entry<String, Object> entry : registro.entrySet()) {
                String clave = entry.getKey();
                Object valor = entry.getValue();

                // Convierte el valor a String (puedes ajustar esta lógica según tus necesidades)
                String valorString = String.valueOf(valor);

                contentValues.put(clave, valorString);
            }

            r = Integer.parseInt(db.insert(tabla, null, contentValues) + "");
            pref.setBool("generaltareo_existenMovimientos", false);
            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            showException(e);
        } finally {
            db.endTransaction();
        }

        return r;
    }





 // wxite la tabal
    public int getTableCount(String tableName) {
        int tableCount = 0;
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();

        // Consulta para obtener el recuento de tablas con el nombre proporcionado
        String query = "SELECT count(*) FROM sqlite_master WHERE type='table' AND name=?";
        Cursor cursor = db.rawQuery(query, new String[]{tableName});

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                tableCount = cursor.getInt(0);
            }
            cursor.close();
        }
        return tableCount;
    }


}
