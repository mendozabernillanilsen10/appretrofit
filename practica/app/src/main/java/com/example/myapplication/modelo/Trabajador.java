package com.example.myapplication.modelo;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class Trabajador{

    @SerializedName("idempresa")
    private String idEmpresa;

    @SerializedName("idtrabajador")
    private String idTrabajador;

    @SerializedName("nombresall")
    private String nombresAll;

    @SerializedName("habilitado")
    private int habilitado;

    @SerializedName("cnrodocumento")
    private String numeroDocumento;

    @SerializedName("idplanilla")
    private String idPlanilla;

    @SerializedName("listanegra")
    private String listaNegra;

    @SerializedName("liquidado")
    private String liquidado;

    @SerializedName("fecha_ingreso")
    private String fechaIngreso;

    @SerializedName("fecha_cese")
    private String fechaCese;

    @SerializedName("fecha_liquidado")
    private String fechaLiquidado;

    // Constructor vacío
    public Trabajador() {
    }

    // Constructor con parámetros
    public Trabajador(String idEmpresa, String idTrabajador, String nombresAll, int habilitado,
                         String numeroDocumento, String idPlanilla, String listaNegra, String liquidado,
                         String fechaIngreso, String fechaCese, String fechaLiquidado) {
        this.idEmpresa = idEmpresa;
        this.idTrabajador = idTrabajador;
        this.nombresAll = nombresAll;
        this.habilitado = habilitado;
        this.numeroDocumento = numeroDocumento;
        this.idPlanilla = idPlanilla;
        this.listaNegra = listaNegra;
        this.liquidado = liquidado;
        this.fechaIngreso = fechaIngreso;
        this.fechaCese = fechaCese;
        this.fechaLiquidado = fechaLiquidado;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombresAll() {
        return nombresAll;
    }

    public void setNombresAll(String nombresAll) {
        this.nombresAll = nombresAll;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(String idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public String getListaNegra() {
        return listaNegra;
    }

    public void setListaNegra(String listaNegra) {
        this.listaNegra = listaNegra;
    }

    public String getLiquidado() {
        return liquidado;
    }

    public void setLiquidado(String liquidado) {
        this.liquidado = liquidado;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(String fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getFechaLiquidado() {
        return fechaLiquidado;
    }

    public void setFechaLiquidado(String fechaLiquidado) {
        this.fechaLiquidado = fechaLiquidado;
    }
// Agrega getters y setters según sea necesario
}
