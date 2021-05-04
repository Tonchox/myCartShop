package com.cartcode.api.cartapirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartcode.api.cartapirest.model.CarritoCompra;
import com.cartcode.api.cartapirest.service.CarritoCompraService;

@RestController
public class CarritoComprasController {
	
	   @Autowired
	    private CarritoCompraService compraService;

	    /*@GetMapping
	    public ResponseEntity<List<Compra>> getAll() {
	        return new ResponseEntity<List<Compra>>(this.compraService.getAll(), HttpStatus.ACCEPTED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Compra> getById(@PathVariable("id") Long idCompra) {
	        return new ResponseEntity<Compra>(this.compraService.getById(idCompra), HttpStatus.ACCEPTED);
	    }*/

	    @PostMapping("/api/saveCarrito")
	    public ResponseEntity<CarritoCompra> save(@RequestBody CarritoCompra compra) {
	        return new ResponseEntity<CarritoCompra>(this.compraService.save(compra), HttpStatus.CREATED);
	    }
}
