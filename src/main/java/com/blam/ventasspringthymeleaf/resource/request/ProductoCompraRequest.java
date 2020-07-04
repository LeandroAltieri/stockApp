package com.blam.ventasspringthymeleaf.resource.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class ProductoCompraRequest {

    @JsonProperty(value = "prod_id")
    @NotNull
    private Long id;
    @JsonProperty(value = "prod_nombre")
    @NotNull
    private String name;
    @JsonProperty(value = "prod_precio_compra")
    @NotNull
    private Double precioCompra;

    @JsonCreator
    public ProductoCompraRequest(@JsonProperty("prod_id") Long id,
                                 @JsonProperty("prod_nombre") String name,
                                 @JsonProperty("prod_precio_compra") Double precioCompra) {
        this.id = id;
        this.name = name;
        this.precioCompra = precioCompra;
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



}
