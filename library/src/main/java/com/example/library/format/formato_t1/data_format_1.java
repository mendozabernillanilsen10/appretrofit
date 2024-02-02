package com.example.library.format.formato_t1;

import java.util.List;
import java.util.Map;

public class data_format_1 {
    private Map<String, Object> response;
    private boolean status;
    private String message;
    private Map<String, Object> body ;

    public Map<String, Object> getResponse() {
        return response;
    }
    public void setResponse(Map<String, Object> response) {
        this.response = response;
        this.status = (boolean) response.get("status");
        this.message = (String) response.get("message");
        this.body = (Map<String, Object>) response.get("data");
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
