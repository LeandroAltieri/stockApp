package com.blam.ventasspringthymeleaf.model;


import com.blam.ventasspringthymeleaf.resource.request.VentaRequest;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ventas")
    private Long id;
    @GeneratedValue(generator = "id_ventas")
    @Column(name ="num_ventas")
    private Integer numVentas;
    @Column(name= "fecha_ventas")
    private String fechaVenta;
    @Column(name="monto_ventas")
    private Double monto;

    public Venta() {
    }

    public Venta(Long id, Integer numVentas, String fechaVenta, Double monto) {
        this.id = id;
        this.numVentas = numVentas;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
    }

    public Venta(Integer numVentas, String fechaVenta, Double monto) {
        this.numVentas = numVentas;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(Integer numVentas) {
        this.numVentas = numVentas;
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
        return "Venta{" +
                "id=" + id +
                ", numVentas=" + numVentas +
                ", fechaVenta=" + fechaVenta +
                ", monto=" + monto +
                '}';
    }

    public static Venta from(VentaRequest ventaRequest){
        return new Venta(ventaRequest.getId(),
                ventaRequest.getNumVenta(),
                ventaRequest.getFechaVenta(),
                ventaRequest.getMonto());
    }

}
