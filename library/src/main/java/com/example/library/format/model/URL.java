package com.example.library.format.model;

public class URL {
    private String url;
    private int tipoPetiocion;
    private String token;
    private String tabla;

    public String getUrl() {
        return url;
    }

    public int getTipoPetiocion() {
        return tipoPetiocion;
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

    public URL(String url, int tipoPetiocion) {
        this.url = url;
        this.tipoPetiocion = tipoPetiocion;
    }

    public URL(String url, int tipoPetiocion, String token) {
        this.url = url;
        this.tipoPetiocion = tipoPetiocion;
        this.token = token;
    }

    public URL(String url, int tipoPetiocion, String token, String tabla) {
        this.url = url;
        this.tipoPetiocion = tipoPetiocion;
        this.token = token;
        this.tabla = tabla;
    }


    @Override
    public String toString() {
        // Customize the string representation as needed
        return "URL: " + this.url + ", Param1: " + this.tipoPetiocion + ", Param2: " + this.token + ", Param3: " + this.tabla;
    }
}