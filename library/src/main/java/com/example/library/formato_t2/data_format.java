package com.example.library.formato_t2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class data_format {
    private Map<String, Object> response;

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




    public Map<String, Object> objetbody(String targetKey) {
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

    public Map<String,Object> header(String targetKey){
        Map<String, Object> result = new HashMap<>();

        if (response != null && response.containsKey("data")) {
            Object dataObject = response.get("data");

            if (dataObject instanceof List) {
                List<Map<String, Object>> dataArray = (List<Map<String, Object>>) dataObject;

                for (Map<String, Object> data : dataArray) {
                    if (data.containsKey(targetKey)) {
                        List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("header");

                        if (content != null) {
                            result = content.isEmpty() ? new HashMap<>() : content.get(0);
                        }
                    }
                }
            }
        }

        return result;
    }




    public void setResponse(Map<String, Object> response) {
        this.response = response;
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
}
