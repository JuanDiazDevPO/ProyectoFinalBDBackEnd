package co.edu.unbosque.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bebida")
public class Bebida {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	String nombre;
	String tipo;
	int stock;
	double precio;
	
	public Bebida() {
		// TODO Auto-generated constructor stub
	}

	public Bebida(Long id, String nombre, String tipo, int stock, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.stock = stock;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Bebida [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", stock=" + stock + ", precio=" + precio
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio, stock, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bebida other = (Bebida) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock
				&& Objects.equals(tipo, other.tipo);
	}
}
