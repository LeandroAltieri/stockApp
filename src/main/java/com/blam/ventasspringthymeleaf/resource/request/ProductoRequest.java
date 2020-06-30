package com.blam.ventasspringthymeleaf.resource.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class ProductoRequest {

    @JsonProperty(value = "prod_id")
    private Long id;
    @JsonProperty(value = "prod_nombre")
    @NotNull
    private String name;
    @JsonProperty(value = "prod_precio")
    @NotNull
    private Double precio;
    @JsonProperty(value = "prod_stock")
    @NotNull
    private Integer stock;

    @JsonCreator
    public ProductoRequest(@JsonProperty("prod_id")Long id,
                           @JsonProperty("prod_nombre") String name,
                           @JsonProperty("prod_precio") Double precio,
                           @JsonProperty("prod_stock") Integer stock) {
        this.id = id;
        this.name = name;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public Double getPrecio() {
        return precio;
    }


    public Integer getStock() {
        return stock;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }


}
