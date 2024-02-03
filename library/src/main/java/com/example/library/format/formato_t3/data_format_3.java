package com.example.library.format.formato_t3;

import android.util.Log;

import com.example.library.database.JSQLite;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class data_format_3 implements Serializable {
    private List<Map<String, Object>> content;
    private List<Map<String, Object>> header;
    private Map<String, Object> body;
    private JSQLite jSQLite;

    public List<Map<String, Object>> getContent() {
        return content;
    }

    public void setContent(List<Map<String, Object>> content) {
        this.content = content;
    }
    public List<Map<String, Object>> getHeader() {
        return header;
    }
    public void setHeader(List<Map<String, Object>> header) {
        this.header = header;
    }

    public Map<String, Object> getBody() {
        return body;
    }
    public void setBody(Map<String, Object> body , JSQLite  jSQLite , String tabla) {
        this.body = body;
        this.header = (List<Map<String, Object>>) body.get("header");
        this.content = (List<Map<String, Object>>) body.get("content");

        Log.d("---------------", "----------------------Insertado Formato 03 -------------------------------------------- ");

                        jSQLite.abrir();
                        if (jSQLite.getTableCount(tabla) == 1) {
                            jSQLite.insertarData3(tabla, header, content);
                        }

        Log.d("---------------", "----------------------Insertado Formato 03 -------------------------------------------- ");

    }


}
