package com.blam.ventasspringthymeleaf.service;


import com.blam.ventasspringthymeleaf.exception.NotFoundException;
import com.blam.ventasspringthymeleaf.model.Venta;
import com.blam.ventasspringthymeleaf.repository.VentaRepository;
import com.blam.ventasspringthymeleaf.resource.request.VentaRequest;
import com.blam.ventasspringthymeleaf.resource.response.VentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class VentaService {

    private VentaRepository ventaRepository;

    @Autowired
    public VentaService(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    public Venta save(Venta venta){
        Venta saved = ventaRepository.save(venta);
        return saved;
    }

    public VentaResponse saveVenta(VentaRequest ventaRequest){
            Venta venta = ventaRepository.save(Venta.from(ventaRequest));
            return  VentaResponse.from(venta);
    }


    public Optional<VentaResponse> ventaById(Long id){
        Optional<Venta> optionalVenta = ventaRepository.findById(id);

            if(optionalVenta==null){
                return Optional.empty();
            }
             Venta venta = optionalVenta.get();

        return Optional.of(VentaResponse.from(venta));
    }

    public void deleteVenta(Long id){
        if (!ventaRepository.existsById(id)) {
            throw new NotFoundException();
        }
            ventaRepository.deleteById(id);
    }

    public List<VentaResponse> getAll(){
        Stream<Venta> stream = StreamSupport.stream(ventaRepository.findAll().spliterator(),false);
        return stream.map(venta -> VentaResponse.from(venta)).collect(Collectors.toList());
    }



}
