package com.blam.ventasspringthymeleaf.resource.response;

import com.blam.ventasspringthymeleaf.model.Producto;
import com.fasterxml.jackson.annotation.JsonProperty;

;

public class ProductoResponse {

    private Long id;
    private String name;
    private Double precioCompra;
    private Double precioVenta;
    private Integer stock;

    public ProductoResponse() {
    }

    public ProductoResponse(Long id, String name, Double precioCompra, Double precioVenta, Integer stock) {
        this.id = id;
        this.name = name;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductoResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", precio_compra=" + precioCompra +
                ", precio_venta=" + precioVenta +
                ", stock=" + stock +
                '}';
    }

    public static ProductoResponse from(Producto producto){
        return new ProductoResponse(producto.getId(),
                                    producto.getName(),
                                    producto.getPrecioCompra(),
                                    producto.getPrecioVenta(),
                                    producto.getStock());
    }

}
