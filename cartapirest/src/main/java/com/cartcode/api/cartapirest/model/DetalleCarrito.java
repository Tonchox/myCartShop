package com.cartcode.api.cartapirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Detalles_Carrito")
public class DetalleCarrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCarrito;
		
	@ManyToOne
	private Producto producto;
	
	private double precio;
	private double precioTotal;
	private int cantidadProducto;
	
    @JsonIgnore
    @ManyToOne
    private CarritoCompra carrito;

	public long getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(long idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public CarritoCompra getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoCompra carrito) {
		this.carrito = carrito;
	}

	@Override
	public String toString() {
		return "DetalleCarrito [idCarrito=" + idCarrito + ", producto=" + producto + ", precio=" + precio
				+ ", precioTotal=" + precioTotal + ", cantidadProducto=" + cantidadProducto + ", carrito=" + carrito
				+ "]";
	}
    
    
    

}
