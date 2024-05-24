package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "puntos")
public class Puntos {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	long id_cliente;
	int cantidad;
	LocalDateTime ultimaRedencion; 
	
	public Puntos() {
		// TODO Auto-generated constructor stub
	}

	public Puntos(Long id, long id_cliente, int cantidad, LocalDateTime ultimaRedencion) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.cantidad = cantidad;
		this.ultimaRedencion = ultimaRedencion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getUltimaRedencion() {
		return ultimaRedencion;
	}

	public void setUltimaRedencion(LocalDateTime ultimaRedencion) {
		this.ultimaRedencion = ultimaRedencion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, id, id_cliente, ultimaRedencion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puntos other = (Puntos) obj;
		return cantidad == other.cantidad && Objects.equals(id, other.id) && id_cliente == other.id_cliente
				&& Objects.equals(ultimaRedencion, other.ultimaRedencion);
	}
	
	

}
