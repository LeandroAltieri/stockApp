package com.blam.ventasspringthymeleaf.service;

import com.blam.ventasspringthymeleaf.model.Producto;
import com.blam.ventasspringthymeleaf.repository.ProductoRepository;
import com.blam.ventasspringthymeleaf.resource.response.ProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductoService {

    private ProductoRepository productoRepository;
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
     }

     public Optional<ProductoResponse> byName(String name){
         Producto producto = productoRepository.findByName(name);
            if(producto==null){
                return Optional.empty();
            }
            return Optional.of(ProductoResponse.from(producto));
     }

    public Optional <ProductoResponse> findByID(Long id){
        Optional <Producto> optionalProducto =  productoRepository.findById(id);
            if(optionalProducto==null){
                Optional.empty();
            }
            Producto producto = optionalProducto.get();
            return Optional.of( ProductoResponse.from(producto));
    }


}
