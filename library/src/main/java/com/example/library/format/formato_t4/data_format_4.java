package com.example.library.format.formato_t4;

import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.util.Log;
import com.example.library.database.JSQLite;
import java.util.List;
import java.util.Map;

public class data_format_4 {
    private Map<String, Object> response;
    private boolean status;
    private JSQLite jSQLite;
    private String message;
    private List<Map<String, Object>> body;

    public Map<String, Object> getResponse() {
        return response;
    }
    public void setResponse(List<Map<String, Object>> dataList, JSQLite jSQLite, String TABLE) {
        if (jSQLite != null) {
            try {
                // Realiza operaciones de inserción en lote asincrónicamente
                new DatabaseTask(jSQLite, TABLE, dataList).execute();
            } catch (SQLiteConstraintException e) {
                Log.d("---------------", "Error al insertar datos: " + e.getMessage());
            }
        } else {
            Log.e("---------------", "JSQLite es nulo en setResponse");
        }
    }

    private static class DatabaseTask extends AsyncTask<Void, Void, Void> {
        private JSQLite jSQLite;
        private String TABLE;
        private List<Map<String, Object>> dataList;
        private long startTime;

        public DatabaseTask(JSQLite jSQLite, String TABLE, List<Map<String, Object>> dataList) {
            this.jSQLite = jSQLite;
            this.TABLE = TABLE;
            this.dataList = dataList;
            this.startTime = startTime;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                jSQLite.abrir();

                for (Map<String, Object> item : dataList) {
                    try {
                        // Inserta datos en la tabla especificada
                        if (jSQLite.getTableCount(TABLE) == 1) {
                            jSQLite.insertData(TABLE, item);
                        }
                    } catch (SQLiteConstraintException e) {
                        Log.d("---------------", "Error al insertar datos: " + e.getMessage());
                    }
                }
                //jSQLite.setTransactionSuccessful();
            } finally {
                // Asegúrate de cerrar la base de datos después de la operación
                //jSQLite.cerrar();
            }
            return null;
        }

        protected void onPostExecute(Integer insertedRecords) {
            // Tiempo total de ejecución
            long totalTime = System.currentTimeMillis() - startTime;

            // Total de registros insertados
            Log.d("---------------", "Total de registros insertados: " + insertedRecords);
            Log.d("---------------", "Tiempo de ejecución: " + totalTime + " milisegundos");

            // Actualizaciones de la interfaz de usuario después de completar las operaciones
        }
    }

    public List<Map<String, Object>> getBody() {
        return body;
    }

    public void setBody(List<Map<String, Object>> body) {
        this.body = body;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
