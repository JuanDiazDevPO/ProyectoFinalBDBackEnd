package co.edu.unbosque.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	long id_bar;
	long id_cliente;
	long id_empleado;
	String fecha;
	String hora;
	double precio;
	int cantidadpersonas;
	
	public Evento() {
		// TODO Auto-generated constructor stub
	}

	
	public Evento(Long id, long id_bar, long id_cliente, long id_empleado, String fecha, String hora, double precio,
			int cantidadpersonas) {
		super();
		this.id = id;
		this.id_bar = id_bar;
		this.id_cliente = id_cliente;
		this.id_empleado = id_empleado;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.cantidadpersonas = cantidadpersonas;
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

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(long id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadpersonas() {
		return cantidadpersonas;
	}

	public void setCantidadpersonas(int cantidadpersonas) {
		this.cantidadpersonas = cantidadpersonas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cantidadpersonas, fecha, hora, id, id_bar, id_cliente, id_empleado, precio);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return cantidadpersonas == other.cantidadpersonas && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora) && Objects.equals(id, other.id) && id_bar == other.id_bar
				&& id_cliente == other.id_cliente && id_empleado == other.id_empleado
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}
	
	

}
