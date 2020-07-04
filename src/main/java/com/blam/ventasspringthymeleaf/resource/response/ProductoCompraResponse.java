package com.blam.ventasspringthymeleaf.resource.response;

import com.blam.ventasspringthymeleaf.model.Producto;

public class ProductoCompraResponse {

    private Long id;
    private String name;
    private Double precioCompra;

    public ProductoCompraResponse() {
    }

    public ProductoCompraResponse(Long id, String name, Double precioCompra) {
        this.id = id;
        this.name = name;
        this.precioCompra = precioCompra;
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

    @Override
    public String toString() {
        return "ProductoCompraResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", precioCompra=" + precioCompra +
                '}';
    }

    public static ProductoCompraResponse from(Producto producto){
        return new ProductoCompraResponse(producto.getId(),
                                          producto.getName(),
                                          producto.getPrecioCompra());
    }

}
