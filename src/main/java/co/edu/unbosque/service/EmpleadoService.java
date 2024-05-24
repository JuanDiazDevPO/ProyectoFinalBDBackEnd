package co.edu.unbosque.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.repository.EmpleadoRepository;


@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository repo;

	public EmpleadoService() {
		// TODO Auto-generated constructor stub
	}

	public void agregarEmpleado(Empleado e) {
		repo.save(e);
	}

	public void eliminarEmpleado(Long id) {
		repo.deleteById(id);
	}

	public void modificarEmpleado(Empleado e) {
		Empleado empleado = repo.findById(e.getId()).orElse(null);
		if (empleado != null) {
			empleado.setNombre(e.getNombre());
			empleado.setDireccion(e.getDireccion());
			empleado.setTelefono(e.getTelefono());
			empleado.setCargo(e.getCargo());
			empleado.setBarID(e.getBarID());
			repo.save(empleado);
		}
	}

	public List<Empleado> obtenerTodosLosEmpleados() {
		return repo.findAll();
	}

	public Optional<List<Empleado>> buscarEmpleadoPorNombre(String nombre) {
		return repo.findByNombre(nombre);
	}

	public boolean login(String usuario, String contraseña) {
		Optional<Empleado> empleadoOptional = repo.findByUsuario(usuario);
		if (empleadoOptional.isPresent()) {
			Empleado empleado = empleadoOptional.get();
			return empleado.getContrasena().equals(contraseña);

		}
		return false;
	}


	public Optional<Empleado> findByUsuario(String usuario) {
		return repo.findByUsuario(usuario);
	}

}
