package com.blam.ventasspringthymeleaf.resource.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import java.sql.Date;

public class VentaRequest {

    @JsonProperty("id")
    private Long id;
    @JsonProperty(value = "num_ventas")
    @NotNull
    private Integer numVenta;
    @JsonProperty("fecha_ventas")
    @NotNull
    private String fechaVenta;
    @JsonProperty("monto_ventas")
    private Double monto;

    @JsonCreator
    public VentaRequest(@JsonProperty("id") Long id,
                        @JsonProperty("num_ventas") Integer numVenta,
                        @JsonProperty("fecha_ventas") String fechaVenta,
                        @JsonProperty("monto_ventas") Double monto) {
        this.id = id;
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumVenta() {
        return numVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public Double getMonto() {
        return monto;
    }


}
