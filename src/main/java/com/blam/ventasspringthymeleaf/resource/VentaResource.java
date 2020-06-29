package com.blam.ventasspringthymeleaf.resource;

import com.blam.ventasspringthymeleaf.model.Venta;
import com.blam.ventasspringthymeleaf.resource.request.VentaRequest;
import com.blam.ventasspringthymeleaf.resource.response.VentaResponse;
import com.blam.ventasspringthymeleaf.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("ventas")
public class VentaResource {

    private VentaService ventaService;

    @Autowired
    public VentaResource(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping(value = "/{id_ventas}" , produces = "application/json")
    public @ResponseBody ResponseEntity<VentaResponse> findVentaById(@PathVariable("id_ventas") Long id){
        Optional<VentaResponse> ventaResponse = ventaService.ventaById(id);
        return ventaResponse.map(vr -> new ResponseEntity(ventaResponse, HttpStatus.OK)).
                orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(produces= "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity<VentaResponse> saveVenta(@RequestBody @Validated VentaRequest ventaRequest){
        Venta venta = Venta.from(ventaRequest);
        Venta saved = ventaService.save(venta);
        VentaResponse ventaResponse = VentaResponse.from(saved);
        return ResponseEntity.ok(ventaResponse);
    }


}
