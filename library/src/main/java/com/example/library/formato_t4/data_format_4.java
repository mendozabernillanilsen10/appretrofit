package com.example.library.formato_t4;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class data_format_4 implements Serializable {
    private List<Map<String, Object>> body;

    public data_format_4(List<Map<String, Object>> body) {
        this.body = body;
    }

    public data_format_4() {
        // Constructor vacío
    }

    public void setBody(List<Map<String, Object>> body) {
        this.body = body;
    }

    public List<Map<String, Object>> getBody() {
        return body;
    }

    public void guardarRegistros(SQLiteDatabase database, long startTime, DataSaveCallback callback) {
        database.beginTransaction();

        try {
            List<String> cabeceras = obtenerCabeceras(body);
            crearTablaDinamica(database, cabeceras);

            for (Map<String, Object> trabajadorMap : body) {
                ContentValues values = new ContentValues();

                for (String cabecera : cabeceras) {
                    if (trabajadorMap.containsKey(cabecera)) {
                        values.put(cabecera, String.valueOf(trabajadorMap.get(cabecera)));
                    }
                }

                database.insert("tb_02", null, values);
            }

            database.setTransactionSuccessful();
            long insertEndTime = System.currentTimeMillis();
            long insertTime = insertEndTime - startTime;

            long insertTimeInSeconds = insertTime / 1000;
            long totalTimeInSeconds = (insertTime) / 1000;
            // Convertir tiempos a minutos
            long insertTimeInMinutes = insertTimeInSeconds / 60;
            long totalTimeInMinutes = totalTimeInSeconds / 60;

            callback.onDataSaveComplete("Inserción: " + insertTimeInSeconds + "s (" + insertTimeInMinutes + "min), " +
                    "Total: " + totalTimeInSeconds + "s (" + totalTimeInMinutes + "min), " +
                    "Se guardaron " + body.size() + " registros");
        } catch (Exception e) {
            callback.onDataSaveError(e);
        } finally {
            database.endTransaction();
        }
    }

    private List<String> obtenerCabeceras(List<Map<String, Object>> registros) {
        if (!registros.isEmpty()) {
            Map<String, Object> cabeceras = registros.get(0);
            return new ArrayList<>(cabeceras.keySet());
        }
        return Collections.emptyList();
    }

    private void crearTablaDinamica(SQLiteDatabase database, List<String> cabeceras) {
        StringBuilder createTableQuery = new StringBuilder("CREATE TABLE IF NOT EXISTS tb_02 (");

        for (String cabecera : cabeceras) {
            createTableQuery.append(cabecera).append(" TEXT, ");
        }
        createTableQuery.delete(createTableQuery.length() - 2, createTableQuery.length()).append(")");
        database.execSQL(createTableQuery.toString());
    }

    public interface DataSaveCallback {
        void onDataSaveComplete(String message);

        void onDataSaveError(Exception e);
    }
}
