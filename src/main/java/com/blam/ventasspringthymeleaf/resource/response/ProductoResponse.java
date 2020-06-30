package com.blam.ventasspringthymeleaf.resource.response;

import com.blam.ventasspringthymeleaf.model.Producto;

public class ProductoResponse {

    private Long id;
    private String name;
    private Double precio;
    private Integer stock;

    public ProductoResponse() {
    }

    public ProductoResponse(Long id, String name, Double precio, Integer stock) {
        this.id = id;
        this.name = name;
        this.precio = precio;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public static ProductoResponse from(Producto producto){
        return new ProductoResponse(producto.getId(),
                                    producto.getName(),
                                    producto.getPrecio(),
                                    producto.getStock());
    }


}
