package co.edu.unbosque.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.model.Bar;
import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.repository.BarRepository;


@Service
public class BarService {
	
	@Autowired
	private BarRepository repo;
	
	public BarService() {
		// TODO Auto-generated constructor stub
	}
	
	public void agregarBar(Bar b) {
		repo.save(b);
	}
	
	public void eliminarBar(Long id) {
	    repo.deleteById(id);
	}

	public void modificarBar(Bar b) {
	    Bar bar = repo.findById(b.getId()).orElse(null);
	    if (bar != null) {
	        bar.setNombre(b.getNombre());
	        bar.setDireccion(b.getDireccion());
	        bar.setTelefono(b.getTelefono());
	        repo.save(bar);
	    }
	}

	public Optional<List<Bar>> buscarBaresPorNombre(String nombre) {
	    return repo.findByNombre(nombre);
	}
	
	public List<Bar> obtenerTodosLosBares() {
		return repo.findAll();
	}


}
