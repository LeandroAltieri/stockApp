package com.blam.ventasspringthymeleaf.resource.response;

import com.blam.ventasspringthymeleaf.model.Producto;

public class ProductoVentaResponse {

    private Long id;
    private String name;
    private Double precioVenta;

    public ProductoVentaResponse() {
    }

    public ProductoVentaResponse(Long id, String name, Double precioVenta) {
        this.id = id;
        this.name = name;
        this.precioVenta = precioVenta;
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
        return precioVenta;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioVenta = precioCompra;
    }

    @Override
    public String toString() {
        return "ProductoCompraResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", precio venta=" + precioVenta +
                '}';
    }

    public static ProductoVentaResponse from(Producto producto){
        return new ProductoVentaResponse(producto.getId(),
                producto.getName(),
                producto.getPrecioVenta());
    }


}
