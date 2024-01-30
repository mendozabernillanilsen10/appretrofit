package com.example.library.formato_t4;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class objet_t4 implements Serializable {
    private List<Map<String, Object>> dynamicList;

    public List<Map<String, Object>> getDynamicList() {
        return dynamicList;
    }
    public void setDynamicList(List<Map<String, Object>> dynamicList) {
        this.dynamicList = dynamicList;
    }
}
