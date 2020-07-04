package com.blam.ventasspringthymeleaf.resource.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductoRequest {

    @JsonProperty(value = "prod_id")
    @NotNull
    private Long id;
    @JsonProperty(value = "prod_nombre")
    @NotNull
    private String name;
    @JsonProperty(value = "prod_precio_compra")
    @NotNull
    private Double precioCompra;
    @JsonProperty(value = "prod_precio_venta")
    @NotNull
    private Double precioVenta;
    @JsonProperty(value = "prod_sotck")
    @NotNull
    private Integer stock;

    @JsonCreator
    public ProductoRequest(@JsonProperty ("prod_id") Long id,
                           @JsonProperty("prod_name") String name,
                           @JsonProperty("prod_precio_compra") Double precioCompra,
                           @JsonProperty("prod_precio_venta") Double precioVenta,
                           @JsonProperty("prod_sotck") Integer stock) {
        this.id = id;
        this.name = name;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public Integer getStock() {
        return stock;
    }
}
