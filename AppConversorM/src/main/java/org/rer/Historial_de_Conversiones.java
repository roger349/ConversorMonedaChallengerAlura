package org.rer;

import javax.persistence.*;


@Entity
@Table(name="Historial_de_Conversiones")
public class Historial_de_Conversiones {

    @Column(name="Correo_Electronico")
      public String correo_electronico;
      @Column(name="Cantidad_Ingresada")
      public Double cantidad_ingresada;
      @Column(name="Moneda_Origen")
      public String moneda_origen;
      @Column(name="Moneda_Destino")
      public String moneda_destino;
      @Column(name="Resultado_Conversion")
      public Double resultado_conversion;
      @Column(name="Fecha_de_Conversion")
      public String fecha_de_conversion;
    // Constructor

    public Historial_de_Conversiones() {
    }

    public Historial_de_Conversiones(String correo_electronico, Double cantidad_ingresada,
                                     String moneda_origen, String moneda_destino, Double resultado_conversion,
                                     String fecha_de_conversion) {

        this.correo_electronico = correo_electronico;
        this.cantidad_ingresada = cantidad_ingresada;
        this.moneda_origen = moneda_origen;
        this.moneda_destino = moneda_destino;
        this.resultado_conversion = resultado_conversion;
        this.fecha_de_conversion = fecha_de_conversion;
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

    public String getFecha_de_conversion() {
        return fecha_de_conversion;
    }

    public void setFecha_de_conversion(String fecha_de_conversion) {
        this.fecha_de_conversion = fecha_de_conversion;
    }
}
