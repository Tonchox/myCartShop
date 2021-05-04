package com.cartcode.api.cartapirest.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartcode.api.cartapirest.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
