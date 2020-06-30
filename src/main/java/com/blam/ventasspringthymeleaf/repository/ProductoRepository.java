package com.blam.ventasspringthymeleaf.repository;

import com.blam.ventasspringthymeleaf.model.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    Optional<Producto> findById(Long id);

    Producto save(Producto producto);

    void deleteById(Long id);

    Producto findByName(String name);


}
