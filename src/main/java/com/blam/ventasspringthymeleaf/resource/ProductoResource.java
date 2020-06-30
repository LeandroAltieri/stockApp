package com.blam.ventasspringthymeleaf.resource;

import com.blam.ventasspringthymeleaf.model.Producto;
import com.blam.ventasspringthymeleaf.resource.response.ProductoResponse;
import com.blam.ventasspringthymeleaf.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/productos")
public class ProductoResource {

    private ProductoService productoService;
    @Autowired
    public ProductoResource(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(value = "/{prod_id}")
    public @ResponseBody ResponseEntity<ProductoResponse> byId(@PathVariable("prod_id") Long id){
        Optional<ProductoResponse> productoResponse = productoService.findByID(id);
        return productoResponse.map(pr -> new ResponseEntity(productoResponse, HttpStatus.OK)).
                orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }









}
