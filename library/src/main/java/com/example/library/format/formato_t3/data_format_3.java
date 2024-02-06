package com.example.library.format.formato_t3;

import android.util.Log;

import com.example.library.database.JSQLite;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class data_format_3 implements Serializable {
    private List<Map<String, Object>> content;
    private List<String> header;
    private Map<String, Object> body;
    private JSQLite jSQLite;

    public List<Map<String, Object>> getContent() {
        return content;
    }

    public void setContent(List<Map<String, Object>> content) {
        this.content = content;
    }

    public Map<String, Object> getBody() {
        return body;
    }
    public void setBody(Map<String, Object> body , JSQLite  jSQLite , String tabla) {
        this.body = body;
        this.header = (List<String>) body.get("header");
        this.content = (List<Map<String, Object>>) body.get("content");

            if (jSQLite.getTableCount(tabla) == 1) {
                jSQLite.abrir();
                jSQLite.insertarData3(tabla, header, content);
            }else{
                Log.d("---------------", " no existe  la tabla : " + tabla);
            }
        Log.d("---------------", "----------------------Insertado Formato 03 -------------------------------------------- ");
    }
}
