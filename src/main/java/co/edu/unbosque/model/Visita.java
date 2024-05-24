package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visita")
public class Visita {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	long id_bar;
	long id_empleado;
	long id_cliente;
	LocalDateTime fechaCreacion;
	double valorCompra;
	
	public Visita() {
		// TODO Auto-generated constructor stub
	}

	public Visita(Long id, long id_bar, long id_empleado, long id_cliente, LocalDateTime fechaCreacion,
			double valorCompra) {
		super();
		this.id = id;
		this.id_bar = id_bar;
		this.id_empleado = id_empleado;
		this.id_cliente = id_cliente;
		this.fechaCreacion = fechaCreacion;
		this.valorCompra = valorCompra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getId_bar() {
		return id_bar;
	}

	public void setId_bar(long id_bar) {
		this.id_bar = id_bar;
	}

	public long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(long id_empleado) {
		this.id_empleado = id_empleado;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, id, id_bar, id_cliente, id_empleado, valorCompra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visita other = (Visita) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(id, other.id)
				&& id_bar == other.id_bar && id_cliente == other.id_cliente && id_empleado == other.id_empleado
				&& Double.doubleToLongBits(valorCompra) == Double.doubleToLongBits(other.valorCompra);
	}
	
}
