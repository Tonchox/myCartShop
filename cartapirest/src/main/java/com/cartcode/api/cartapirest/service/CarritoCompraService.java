package com.cartcode.api.cartapirest.service;

import java.util.List;

import com.cartcode.api.cartapirest.model.CarritoCompra;

public interface CarritoCompraService {
	    
	public List<CarritoCompra> getAll();

    public CarritoCompra getById(Long idCompra);

    public CarritoCompra save(CarritoCompra compra);
}
