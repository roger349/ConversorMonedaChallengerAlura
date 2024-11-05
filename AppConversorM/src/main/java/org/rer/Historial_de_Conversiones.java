package org.rer;

public class Historial_de_Conversiones {

    public String correo_electronico;
    public Double cantidad_ingresada;
    public String moneda_origen;
    public String moneda_destino;
    public Double resultado_conversion;
    public String fecha_conversion;

    // Constructor

    public Historial_de_Conversiones() {
    }

    public Historial_de_Conversiones(String correo_electronico, Double cantidad_ingresada,
                                     String moneda_origen, String moneda_destino, Double resultado_conversion,
                                     String fecha_conversion) {

        this.correo_electronico = correo_electronico;
        this.cantidad_ingresada = cantidad_ingresada;
        this.moneda_origen = moneda_origen;
        this.moneda_destino = moneda_destino;
        this.resultado_conversion = resultado_conversion;
        this.fecha_conversion = fecha_conversion;
    }

    // Getters y setters

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public Double getCantidad_ingresada() {
        return cantidad_ingresada;
    }

    public void setCantidad_ingresada(Double cantidad_ingresada) {
        this.cantidad_ingresada = cantidad_ingresada;
    }

    public String getMoneda_origen() {
        return moneda_origen;
    }

    public void setMoneda_origen(String moneda_origen) {
        this.moneda_origen = moneda_origen;
    }

    public String getMoneda_destino() {
        return moneda_destino;
    }

    public void setMoneda_destino(String moneda_destino) {
        this.moneda_destino = moneda_destino;
    }

    public Double getResultado_conversion() {
        return resultado_conversion;
    }

    public void setResultado_conversion(Double resultado_conversion) {
        this.resultado_conversion = resultado_conversion;
    }
    public String getFecha_conversion() {
        return fecha_conversion;
    }

    public void setFecha_conversion(String fecha_conversion) {
        this.fecha_conversion = fecha_conversion;
    }
}
