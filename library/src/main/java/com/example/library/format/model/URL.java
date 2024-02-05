package com.example.library.format.model;

public class URL {
    private String url;
    private int tipoPeticion;
    private String token;
    private String tabla;

    public String getUrl() {
        return url;
    }



    public String getToken() {
        return token;
    }

    public String getTabla() {
        return tabla;
    }

    public URL(String url) {
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTipoPeticion() {
        return tipoPeticion;
    }

    public void setTipoPeticion(int tipoPeticion) {
        this.tipoPeticion = tipoPeticion;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public URL(String url, int tipoPeticion) {
        this.url = url;
        this.tipoPeticion = tipoPeticion;
    }

    public URL(String url, int tipoPeticion, String token) {
        this.url = url;
        this.tipoPeticion = tipoPeticion;
        this.token = token;
    }

    public URL(String url, int tipoPeticion, String token, String tabla) {
        this.url = url;
        this.tipoPeticion = tipoPeticion;
        this.token = token;
        this.tabla = tabla;
    }

    public URL() {
    }
}