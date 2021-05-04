package com.cartcode.api.cartapirest.service;

import java.util.List;

import com.cartcode.api.cartapirest.model.Cliente;

public interface ClienteService {
    
	public List<Cliente> getAll();

    public Cliente getById(Long idCliente);

    public Cliente save(Cliente cliente);

    public Cliente update(Cliente cliente);

    public Cliente checkCredentials(String userName, String password);
}
