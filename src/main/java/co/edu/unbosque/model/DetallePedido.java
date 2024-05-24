package co.edu.unbosque.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detallepedido")
public class DetallePedido {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	int cantidad;
	long id_pedido;
	long id_bebida;
	
	public DetallePedido() {
		// TODO Auto-generated constructor stub
	}

	public DetallePedido(Long id, int cantidad, long id_pedido, long id_bebida) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.id_pedido = id_pedido;
		this.id_bebida = id_bebida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public long getId_bebida() {
		return id_bebida;
	}

	public void setId_bebida(long id_bebida) {
		this.id_bebida = id_bebida;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", cantidad=" + cantidad + ", id_pedido=" + id_pedido + ", id_bebida="
				+ id_bebida + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, id, id_bebida, id_pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallePedido other = (DetallePedido) obj;
		return cantidad == other.cantidad && Objects.equals(id, other.id) && id_bebida == other.id_bebida
				&& id_pedido == other.id_pedido;
	}
}
