package com.example.library.formato_t3;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class data_format_3 implements Serializable {


    private List<Map<String, Object>> content;
    private List<Map<String, Object>> header;
    private Map<String, Object> body;

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
    public void setBody(Map<String, Object> body) {
        this.body = body;
        this.header = (List<Map<String, Object>>) body.get("header");
        this.content = (List<Map<String, Object>>) body.get("content");
    }

}
