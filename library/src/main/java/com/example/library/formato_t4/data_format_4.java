package com.example.library.formato_t4;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class data_format_4 implements Serializable {
    private List<Map<String, Object>> body;


    public data_format_4() {
    }

    ///

    public data_format_4(List<Map<String, Object>> body) {
        this.body = body;
    }

    public List<Map<String, Object>> getBody() {
        return body;
    }
    public void setBody(List<Map<String, Object>> body) {
        this.body = body;
    }
}
