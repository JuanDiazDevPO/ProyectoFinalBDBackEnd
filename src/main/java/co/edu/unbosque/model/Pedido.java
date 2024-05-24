package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	Long id_bar;
	Long id_cliente;
	LocalDateTime fechaCreacion;

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	
	public Pedido(Long id, Long id_bar, Long id_cliente,  LocalDateTime fechaCreacion) {
		super();
		this.id = id;
		this.id_bar = id_bar;
		this.id_cliente = id_cliente;
		this.fechaCreacion = fechaCreacion;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_bar() {
		return id_bar;
	}

	public void setId_bar(Long id_bar) {
		this.id_bar = id_bar;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}




	@Override
	public String toString() {
		return "Pedido [id=" + id + ", id_bar=" + id_bar + ", id_cliente=" + id_cliente + ", fechaCreacion="
				+ fechaCreacion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, id, id_bar, id_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(id, other.id)
				&& Objects.equals(id_bar, other.id_bar) && Objects.equals(id_cliente, other.id_cliente);
	}
}
