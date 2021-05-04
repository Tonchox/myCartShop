package com.cartcode.api.cartapirest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cartcode.api.cartapirest.model.Producto;
import com.cartcode.api.cartapirest.repositoy.ProductoRepository;
import com.cartcode.api.cartapirest.service.ProductoService;

@Service
@Transactional(readOnly = true)
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public Producto getById(Long idProducto) {
		return productoRepository.getOne(idProducto);
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		return productoRepository.saveAndFlush(producto);
	}

	@Override
	public void updateStock(Long idProducto, int cantidad) {
        Producto producto = this.getById(idProducto);
        producto.setCantidad(producto.getCantidad() - cantidad);
        this.update(producto);
	}
	
}
