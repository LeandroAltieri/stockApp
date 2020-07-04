package com.blam.ventasspringthymeleaf.resource.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class ProductoVentaRequest {


    @JsonProperty(value = "prod_id")
    @NotNull
    private Long id;
    @JsonProperty(value = "prod_nombre")
    @NotNull
    private String name;
    @JsonProperty(value = "prod_precio_venta")
    @NotNull
    private Double precioVenta;

    @JsonCreator
    public ProductoVentaRequest(@JsonProperty("prod_id") Long id,
                                 @JsonProperty("prod_nombre") String name,
                                 @JsonProperty("prod_precio_venta") Double precioVenta) {
        this.id = id;
        this.name = name;
        this.precioVenta = precioVenta;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }




}
