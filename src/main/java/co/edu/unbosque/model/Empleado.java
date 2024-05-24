package co.edu.unbosque.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	String nombre;
	String direccion;
	String cargo;
	String usuario;
	String contrasena;
	int telefono;
	long id_bar;

	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(Long id, String nombre, String direccion, String cargo, String usuario, String contrasena,
			int telefono, long id_bar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cargo = cargo;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.id_bar = id_bar;
	}


	public long getBarID() {
		return id_bar;
	}



	public void setBarID(long barID) {
		this.id_bar = barID;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", cargo=" + cargo
				+ ", telefono=" + telefono + ", bar=" + id_bar + "]";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = hashSHA256(contrasena);
	}
	public long getid_bar() {
		return id_bar;
	}

	public void setid_bar(long id_bar) {
		this.id_bar = id_bar;
	}

	public String hashSHA256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_bar, cargo, contrasena, direccion, id, nombre, telefono, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return id_bar == other.id_bar && Objects.equals(cargo, other.cargo)
				&& Objects.equals(contrasena, other.contrasena) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre) && telefono == other.telefono
				&& Objects.equals(usuario, other.usuario);
	}
}
