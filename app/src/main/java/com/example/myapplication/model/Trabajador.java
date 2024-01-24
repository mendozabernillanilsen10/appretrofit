package com.example.myapplication.model;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Trabajador implements Serializable {

    private String idempresa;
    private String idtrabajador;
    private String nombresall;

    private int habilitado;

    private String cnrodocumento;

    private String idplanilla;

    private String listanegra;
    private String liquidado;
    private String fecha_ingreso;

    private String fecha_cese;

    private String fecha_liquidado;

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(String idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getNombresall() {
        return nombresall;
    }

    public void setNombresall(String nombresall) {
        this.nombresall = nombresall;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public String getCnrodocumento() {
        return cnrodocumento;
    }

    public void setCnrodocumento(String cnrodocumento) {
        this.cnrodocumento = cnrodocumento;
    }

    public String getIdplanilla() {
        return idplanilla;
    }

    public void setIdplanilla(String idplanilla) {
        this.idplanilla = idplanilla;
    }

    public String getListanegra() {
        return listanegra;
    }

    public void setListanegra(String listanegra) {
        this.listanegra = listanegra;
    }

    public String getLiquidado() {
        return liquidado;
    }

    public void setLiquidado(String liquidado) {
        this.liquidado = liquidado;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_cese() {
        return fecha_cese;
    }

    public void setFecha_cese(String fecha_cese) {
        this.fecha_cese = fecha_cese;
    }

    public String getFecha_liquidado() {
        return fecha_liquidado;
    }

    public void setFecha_liquidado(String fecha_liquidado) {
        this.fecha_liquidado = fecha_liquidado;
    }
    public ContentValues toValues() {
        ContentValues values = new ContentValues();
        values.put("idempresa", idempresa);
        values.put("idtrabajador", idtrabajador);
        values.put("nombresall", nombresall);
        values.put("habilitado", habilitado);
        values.put("cnrodocumento", cnrodocumento);
        values.put("idplanilla", idplanilla);
        values.put("listanegra", listanegra);
        values.put("liquidado", liquidado);
        values.put("fecha_ingreso", fecha_ingreso);
        values.put("fecha_cese", fecha_cese);
        values.put("fecha_liquidado", fecha_liquidado);
        return values;
    }
}
