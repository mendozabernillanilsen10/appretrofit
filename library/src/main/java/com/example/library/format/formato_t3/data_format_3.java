package com.example.library.format.formato_t3;

import com.example.library.database.JSQLite;

import java.util.List;
import java.util.Map;

public class data_format_3 {
    private List<String> header;
    private List<Map<String, Object>> content;
    private String tableName; // Nuevo campo para almacenar el nombre de la base de datos

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<Map<String, Object>> getContent() {
        return content;
    }
    public void setContent(List<Map<String, Object>> content, JSQLite jSQLite, String tableName, List<String> header) {
        this.content = content;
        this.tableName = tableName; // Establecer el nombre de la tabla
        for (Map<String, Object> data : content) {
            //jSQLite.insertData3(this.toString(), data, header); // Pasar la instancia actual (this)
        }
    }
}
