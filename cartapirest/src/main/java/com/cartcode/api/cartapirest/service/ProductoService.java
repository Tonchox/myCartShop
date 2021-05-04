package com.cartcode.api.cartapirest.service;

import java.util.List;

import com.cartcode.api.cartapirest.model.Producto;

public interface ProductoService {
    
	public List<Producto> getAll();

    public Producto getById(Long idProducto);

    public Producto save(Producto producto);

    public Producto update(Producto producto);

    public void updateStock(Long idProducto, int cantidad);
}
