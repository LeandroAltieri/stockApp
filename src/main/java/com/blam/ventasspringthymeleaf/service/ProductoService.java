package com.blam.ventasspringthymeleaf.service;

import com.blam.ventasspringthymeleaf.exception.NotFoundException;
import com.blam.ventasspringthymeleaf.model.Producto;
import com.blam.ventasspringthymeleaf.repository.ProductoRepository;
import com.blam.ventasspringthymeleaf.resource.response.ProductoCompraResponse;
import com.blam.ventasspringthymeleaf.resource.response.ProductoResponse;
import com.blam.ventasspringthymeleaf.resource.response.ProductoVentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
     }

     public List<ProductoResponse> getAllProducto(){
        Stream<Producto>stream = StreamSupport.stream(productoRepository.findAll().spliterator(), false);
       return stream.map(producto -> ProductoResponse.from(producto)).collect(Collectors.toList());
     }

    public List<ProductoCompraResponse> getAllProductoCompra(){
        Stream<Producto>stream = StreamSupport.stream(productoRepository.findAll().spliterator(), false);
        return stream.map(producto -> ProductoCompraResponse.from(producto)).collect(Collectors.toList());
    }

    public List<ProductoVentaResponse> getAllProductoVenta(){
        Stream<Producto>stream = StreamSupport.stream(productoRepository.findAll().spliterator(), false);
        return stream.map(producto -> ProductoVentaResponse.from(producto)).collect(Collectors.toList());
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
