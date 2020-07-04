package com.blam.ventasspringthymeleaf.resource;


import com.blam.ventasspringthymeleaf.resource.response.ProductoCompraResponse;
import com.blam.ventasspringthymeleaf.resource.response.ProductoResponse;
import com.blam.ventasspringthymeleaf.resource.response.ProductoVentaResponse;
import com.blam.ventasspringthymeleaf.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping(value = "/productos")
public class ProductoResource {

    private ProductoService productoService;
    @Autowired
    public ProductoResource(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(value = "/{prod_id}")
    public @ResponseBody ResponseEntity<ProductoResponse> getById(@PathVariable("prod_id") Long id){
        Optional<ProductoResponse> productoResponse = productoService.findByID(id);
        return productoResponse.map(pr -> new ResponseEntity(productoResponse, HttpStatus.OK)).
                orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value = "/listar")
    public @ResponseBody ResponseEntity<List<ProductoResponse>> getAll(){
        List<ProductoResponse> listResponse = productoService.getAllProducto();
        return ok(listResponse);
    }


    @GetMapping(value = "/listarCompra")
    public @ResponseBody ResponseEntity<List<ProductoCompraResponse>> getAllProductoCompra(){
        List<ProductoCompraResponse> listResponse = productoService.getAllProductoCompra();
        return ok(listResponse);
    }

    @GetMapping(value = "/listarVenta")
    public @ResponseBody ResponseEntity<List<ProductoVentaResponse>> getAllProductoVenta(){
        List<ProductoVentaResponse> listResponse = productoService.getAllProductoVenta();
        return ok(listResponse);
    }





    @GetMapping(value = "/listar/{prod_nombre}")
    public @ResponseBody ResponseEntity<ProductoResponse> getByName(@PathVariable("prod_nombre") String name){
        Optional<ProductoResponse> productoResponse = productoService.byName(name);
        return  productoResponse.map(pr -> new ResponseEntity(productoResponse,HttpStatus.OK)).
                orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }




}
