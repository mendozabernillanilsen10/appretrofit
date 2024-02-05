package com.example.library.format.formato_t2;
import android.util.Log;

import com.example.library.database.JSQLite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class data_format_2 {
    private Map<String, Object> response;
    private JSQLite jSQLite;
    private Object dataObject ;
    private List<Map<String, Object>>  body ;

    public data_format_2() {
    }

    public Map<String, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Object> response, JSQLite jSQLite) {
        this.response = response;
        this.jSQLite = jSQLite;
        this.body = (List<Map<String, Object>>) response.get("data");

        if (body != null) {
            for (Map<String, Object> entry : body) {
                for (String key : entry.keySet()) {
                    if (this.jSQLite.getTableCount(key) == 1) {
                        Log.d("---------------", "nombre de la tabla : " + key);

                        Map<String, Object>  entry_body = (Map<String, Object>) entry.get(key);
                        jSQLite.abrir();
                        jSQLite.Insertar_02(key, entry_body);


                    }else{
                        Log.d("---------------", " no existe  la tabla : " + key);
                    }
                }
            }
        }
        Log.d("---------------", "----------------------Insertado Formato 02-------------------------------------------- ");

    }
    public JSQLite getjSQLite() {
        return jSQLite;
    }
    public void setjSQLite(JSQLite jSQLite) {
        this.jSQLite = jSQLite;
    }
}
