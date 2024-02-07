package com.example.library.format.formato_t1;

import android.content.Context;
import android.util.Log;

import com.example.library.database.JSQLite;


import java.util.List;
import java.util.Map;

public class data_format_1 {
    private Map<String, Object> response;
    private boolean status;
    private JSQLite jSQLite;

    private String message;
    private Map<String, Object> body ;

    public Map<String, Object> getResponse() {
        return response;
    }
    public void setResponse(Map<String, Object> response , JSQLite jSQLite) {

        this.response = response;
        this.status = (boolean) response.get("status");
        this.message = (String) response.get("message");
        this.body = (Map<String, Object>) response.get("data");
        this.jSQLite = jSQLite;

        for (Map.Entry<String, Object> entry : body.entrySet()) {
            // Check if table count is 1 for the current key
            if (this.jSQLite.getTableCount(entry.getKey()) == 1) {
               // Log.d("---------------", "nombre de la tabla  : " + entry.getKey());
                this.jSQLite.abrir();
                if (entry.getValue() instanceof List) {
                    List<Map<String, Object>> list = (List<Map<String, Object>>) entry.getValue();
                    for (Map<String, Object> map : list) {
                      jSQLite.InsertarFormato_01(entry.getKey(), map);
                    }
                }

            }else{
                Log.d("---------------", " no existe  la tabla : " + entry.getKey());

            }
        }
        Log.d("---------------", "----------------------Insertado Formato 01 -------------------------------------------- ");



    }
    public List<Map<String, Object>>  getIten( String key) {
        return (List<Map<String, Object>>) body.get(key);
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

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
