package com.blam.ventasspringthymeleaf.resource.response;

import com.blam.ventasspringthymeleaf.model.Venta;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class VentaResponse {

        private Long id;
        private Integer numVenta;
        private String fechaVenta;
        private Double monto;

    public VentaResponse() {
    }

    public VentaResponse(Long id, Integer numVenta, String fechaVenta, Double monto) {
        this.id = id;
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(Integer numVenta) {
        this.numVenta = numVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "VentaResponse{" +
                "id=" + id +
                ", numVenta=" + numVenta +
                ", fechaVenta=" + fechaVenta +
                ", monto=" + monto +
                '}';
    }

    public static VentaResponse from(Venta venta){
        return new VentaResponse(venta.getId(), venta.getNumVentas(), venta.getFechaVenta(), venta.getMonto());

    }

}
