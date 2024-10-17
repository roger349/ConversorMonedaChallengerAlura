package org.rer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="Historial_de_Conversiones")
public class Historial_de_Conversiones {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long id;
      @Column(name="Correo_Electronico")
      public String correo_electronico;
      @Column(name="Cantidad_Ingresada")
      public BigDecimal cantidad_ingresada;
      @Column(name="Moneda_Origen")
      public String moneda_origen;
      @Column(name="Moneda_Destino")
      public String moneda_destino;
      @Column(name="Resultado_Conversion")
      public BigDecimal resultado_conversion;
      @Column(name="Fecha_de_Conversion")
      public LocalDate fecha_de_conversion;
    // Constructor
    public Historial_de_Conversiones(String correo_electronico, BigDecimal cantidad_ingresada,
                                     String moneda_origen, String moneda_destino, BigDecimal resultado_conversion,
                                     LocalDate fecha_de_conversion) {
        this.correo_electronico = correo_electronico;
        this.cantidad_ingresada = cantidad_ingresada;
        this.moneda_origen = moneda_origen;
        this.moneda_destino = moneda_destino;
        this.resultado_conversion = resultado_conversion;
        this.fecha_de_conversion = fecha_de_conversion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public BigDecimal getCantidad_ingresada() {
        return cantidad_ingresada;
    }

    public void setCantidad_ingresada(BigDecimal cantidad_ingresada) {
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

    public BigDecimal getResultado_conversion() {
        return resultado_conversion;
    }

    public void setResultado_conversion(BigDecimal resultado_conversion) {
        this.resultado_conversion = resultado_conversion;
    }

    public LocalDate getFecha_de_conversion() {
        return fecha_de_conversion;
    }

    public void setFecha_de_conversion(LocalDate fecha_de_conversion) {
        this.fecha_de_conversion = fecha_de_conversion;
    }
}
