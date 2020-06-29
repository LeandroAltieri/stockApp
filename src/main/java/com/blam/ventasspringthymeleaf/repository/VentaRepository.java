package com.blam.ventasspringthymeleaf.repository;

import com.blam.ventasspringthymeleaf.model.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Long> {

    Optional<Venta> findById(Long id);



    Venta save(Venta venta);

    Iterable<Venta> findAll();



}
