package com.cartcode.api.cartapirest.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cartcode.api.cartapirest.model.CarritoCompra;
import com.cartcode.api.cartapirest.model.Producto;
import com.cartcode.api.cartapirest.repositoy.CarritoCompraRepositoy;
import com.cartcode.api.cartapirest.repositoy.DetalleCompraRepository;
import com.cartcode.api.cartapirest.service.CarritoCompraService;
import com.cartcode.api.cartapirest.service.ProductoService;

@Service
@Transactional(readOnly = true)
public class CarritoCompraServiceImpl implements CarritoCompraService{
	
	@Autowired
    private CarritoCompraRepositoy carritoCompraRepository;

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Autowired
    private ProductoService productoService;

	@Override
	public List<CarritoCompra> getAll() {
		return carritoCompraRepository.findAll();
	}

	@Override
	public CarritoCompra getById(Long idCompra) {
		return carritoCompraRepository.getOne(idCompra);
	}

	@Override
	 @Transactional(readOnly = false)
	public CarritoCompra save(CarritoCompra compra) {
		compra.setFechaCompra(new Date());

        // Calcular el total de los productos
		compra.setImporteTotal(
                compra.getListaDetalleCarrito()
                        .stream()
                        .mapToDouble(detalle -> {
                            // Calcula precio del producto * cantidad
                            Producto producto = productoService.getById(detalle.getProducto().getIdProducto());
                            detalle.setPrecio(producto.getPrecio());
                            detalle.setPrecioTotal(producto.getPrecio() * detalle.getCantidadProducto());

                            return detalle.getPrecioTotal();
                        })
                        .sum()
        );

        // Actualizar stock de cada producto
		compra.getListaDetalleCarrito()
                .forEach(detalle -> productoService.updateStock(detalle.getProducto().getIdProducto(), detalle.getCantidadProducto()));

		carritoCompraRepository.save(compra);

        compra.getListaDetalleCarrito().forEach(detalleCompra -> {
            detalleCompra.setCarrito(compra);
            detalleCompraRepository.save(detalleCompra);
        });
        return compra;
    }

    
}
