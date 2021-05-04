package com.cartcode.api.cartapirest.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartcode.api.cartapirest.model.CarritoCompra;

@Repository
public interface CarritoCompraRepositoy extends JpaRepository<CarritoCompra, Long>{

}
