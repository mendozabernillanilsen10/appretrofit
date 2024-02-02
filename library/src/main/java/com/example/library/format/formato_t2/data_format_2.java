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
    public void setResponse(Map<String, Object> response , JSQLite jSQLite) {
        this.response = response;
        this.jSQLite = jSQLite;
        this.body = (List<Map<String, Object>>) response.get("data");
        if (body != null) {
            for (Map<String, Object> entry : body) {
                for (String key : entry.keySet()) {
                    if(this.jSQLite.getTableCount(key) == 1){
                        if (key.equals(key)) {
                            Log.d("---------------", "nombre de la tabla : " + key );
                            Map<String, Object> formatocosecha = (Map<String, Object>) entry.get(key);
                            if (formatocosecha.containsKey("header")) {
                                Map<String, Object> header = (Map<String, Object>) formatocosecha.get("header");
                                // Log the column names from the header
                                for (Object columnName : header.values()) {
                                    Log.d("---------------", "header: " + columnName);
                                }
                            }
                            if (formatocosecha.containsKey("data")) {
                                List<Map<String, Object>> contentList = (List<Map<String, Object>>) formatocosecha.get("data");
                                for (Map<String, Object> content : contentList) {
                                    Log.d("---------------", "columna "+content.toString());
                                }
                            }
                        }
                    }
                    Log.d("---------------", "------------------------------------------------------------------ ");


                }
            }
        }




        /*
        for (Map.Entry<String, Object> entry : body.entrySet()) {
            // Check if table count is 1 for the current key
            if (this.jSQLite.getTableCount(entry.getKey()) == 1) {
                this.jSQLite.abrir();

                /*

                if (entry.getValue() instanceof List) {
                    List<Map<String, Object>> list = (List<Map<String, Object>>) entry.getValue();
                    for (Map<String, Object> map : list) {
                        // Log key-value pairs within the list
                        jSQLite.insertData(entry.getKey(), map);
                        Log.d("---------------", "------------------------------------------------------------------ ");
                    }
                }



            }
        }

*/
    }
    public JSQLite getjSQLite() {
        return jSQLite;
    }
    public void setjSQLite(JSQLite jSQLite) {
        this.jSQLite = jSQLite;
    }
/*
    public Map<String, Object> getResponse() {
        return response;


    }

    public List<Map<String, Object>> listbody() {
        List<Map<String, Object>> result = new ArrayList<>();

        if (response != null && response.containsKey("data")) {
            Object dataObject = response.get("data");

            if (dataObject instanceof List) {
                List<Map<String, Object>> dataArray = (List<Map<String, Object>>) dataObject;
                result.addAll(dataArray);
            }
        }
        return result;
    }
    public Map<String, Object> body(String targetKey) {
        Map<String, Object> result = new HashMap<>();
        if (response != null && response.containsKey("data")) {
            Object dataObject = response.get("data");

            if (dataObject instanceof List) {
                List<Map<String, Object>> dataArray = (List<Map<String, Object>>) dataObject;

                for (Map<String, Object> data : dataArray) {
                    if (data.containsKey(targetKey)) {
                        result = data.get(targetKey) instanceof Map ? (Map<String, Object>) data.get(targetKey) : new HashMap<>();
                    }
                }
            }
        }
        return result;
    }
    public List<Map<String, Object>> headerlist(String targetKey) {
        List<Map<String, Object>> headers = new ArrayList<>();
        Object dataObject = response.get("data");
        if (dataObject instanceof List) {
            List<Map<String, Object>> dataArray = (List<Map<String, Object>>) dataObject;
            for (Map<String, Object> data : dataArray) {
                if (data.containsKey(targetKey)) {
                    Map<String, Object> formatocosecha = (Map<String, Object>) data.get(targetKey);
                    if (formatocosecha.containsKey("header")) {
                        Map<String, Object> header = (Map<String, Object>) formatocosecha.get("header");
                        headers.add(header);
                    }
                }
            }
        }
        return headers;
    }
    public List<Map<String, Object>> contentlist(String targetKey) {
        List<Map<String, Object>> content = new ArrayList<>();
        Object dataObject = response.get("data");
        if (dataObject instanceof List) {
            List<Map<String, Object>> dataArray = (List<Map<String, Object>>) dataObject;
            for (Map<String, Object> data : dataArray) {
                if (data.containsKey(targetKey)) {
                    Map<String, Object> formatocosecha = (Map<String, Object>) data.get(targetKey);
                    if (formatocosecha.containsKey("data")) {
                        List<Map<String, Object>> contentList = (List<Map<String, Object>>) formatocosecha.get("data");
                        content.addAll(contentList);
                    }
                }
            }
        }
        return content;
    }



    public boolean status() {
        return response != null && response.containsKey("status") && (boolean) response.get("status");
    }
    public String message() {
        return response != null && response.containsKey("message") ? (String) response.get("message") : "";
    }
    public  int code() {
        return response != null && response.containsKey("code") ? (int) response.get("code") : 0;
    }

    public  String title () {
        return response != null && response.containsKey("title") ? (String) response.get("title") : "";
    }
    public  String messageError() {
        return response != null && response.containsKey("messageError") ? (String) response.get("messageError") : "";
    }
    public  String function_name() {
        return response != null && response.containsKey("function_name") ? (String) response.get("function_name") : "";
    }
    */
}
