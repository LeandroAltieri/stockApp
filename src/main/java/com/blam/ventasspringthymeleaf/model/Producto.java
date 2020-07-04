package com.blam.ventasspringthymeleaf.model;

import com.blam.ventasspringthymeleaf.resource.request.ProductoCompraRequest;
import com.blam.ventasspringthymeleaf.resource.request.ProductoRequest;
import com.blam.ventasspringthymeleaf.resource.response.ProductoResponse;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long id;
    @Column(name = "prod_nombre")
    private String name;
    @Column(name = "prod_precio_compra")
    private Double precioCompra;
    @Column(name = "prod_precio_venta")
    private Double precioVenta;
    @Column(name = "prodStock")
    private Integer stock;

    public Producto() {
    }

    public Producto(Long id, String name, Double precioCompra, Double precioVenta, Integer stock) {
        this.id = id;
        this.name = name;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public Producto(Long id, String name, Double precioCompraVenta) {
        this.id = id;
        this.name = name;
        this.precioCompra = precioCompraVenta;
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
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", stock=" + stock +
                '}';
    }

    public static Producto from(ProductoRequest productoRequest){
        return new Producto(productoRequest.getId(),
                            productoRequest.getName(),
                            productoRequest.getPrecioCompra(),
                            productoRequest.getPrecioVenta(),
                            productoRequest.getStock());
    }

    public static Producto from(ProductoCompraRequest productoCompraRequest){
        return new Producto(productoCompraRequest.getId(),
                            productoCompraRequest.getName(),
                            productoCompraRequest.getPrecioCompra());
    }

}
