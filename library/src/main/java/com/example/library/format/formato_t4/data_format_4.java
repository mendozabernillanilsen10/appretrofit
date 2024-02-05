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
    private  String TABLE;
    private List<Map<String, Object>> body;

    public Map<String, Object> getResponse() {
        return response;
    }
    public void setResponse(List<Map<String, Object>> dataList,JSQLite db, String TABLE) {
        this.body = dataList;
        this.TABLE = TABLE;
        this.jSQLite = db;

        if (this != null) {
            try {
                this.jSQLite.abrir();
                // Crea una instancia de DatabaseTask y ejecútala
                JSQLite.DatabaseTask databaseTask = new JSQLite.DatabaseTask(this.jSQLite, TABLE, dataList);
                databaseTask.execute();
            } catch (SQLiteConstraintException e) {
                Log.d("---------------", "Error al insertar datos: " + e.getMessage());
            }
        } else {
            Log.e("---------------", "JSQLite es nulo en setResponse");
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