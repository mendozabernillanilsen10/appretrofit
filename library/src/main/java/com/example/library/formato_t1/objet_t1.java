package com.example.library.formato_t1;

import java.io.Serializable;
import java.util.Map;

public class objet_t1 implements Serializable  {
    boolean status;
    private Map<String, data_t1> data;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Map<String, data_t1> getData() {
        return data;
    }

    public void setData(Map<String, data_t1> data) {
        this.data = data;
    }
}
