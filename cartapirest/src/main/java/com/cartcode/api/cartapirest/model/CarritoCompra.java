package com.cartcode.api.cartapirest.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Carritos_Compra")
public class CarritoCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Cliente cliente;
	
	private Double importeTotal;
	private Date fechaCompra;
	
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrito")
    private List<DetalleCarrito> listaDetalleCarrito;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Double getImporteTotal() {
		return importeTotal;
	}


	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}


	public Date getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public List<DetalleCarrito> getListaDetalleCarrito() {
		return listaDetalleCarrito;
	}


	public void setListaDetalleCarrito(List<DetalleCarrito> listaDetalleCarrito) {
		this.listaDetalleCarrito = listaDetalleCarrito;
	}


	@Override
	public String toString() {
		return "CarritoCompra [id=" + id + ", cliente=" + cliente + ", importeTotal=" + importeTotal + ", fechaCompra="
				+ fechaCompra + ", listaDetalleCarrito=" + listaDetalleCarrito + "]";
	}
    
    
    
}
