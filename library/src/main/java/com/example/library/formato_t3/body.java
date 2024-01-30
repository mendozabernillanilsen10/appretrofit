package com.example.library.formato_t3;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class body implements Serializable {
    private List<Map<String, Object>> content;
    private List<Map<String, Object>> header;
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
}
