package co.edu.unbosque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.model.Bar;
import co.edu.unbosque.model.Visita;
import co.edu.unbosque.repository.VisitaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VisitaService {

	@Autowired
	private VisitaRepository repo;

	public void agregarVisita(Visita visita) {
		repo.save(visita);
	}

	public void eliminarVisita(Long id) {
		repo.deleteById(id);
	}

	public void modificarVisita(Visita visita) {
		Visita visitaExistente = repo.findById(visita.getId()).orElse(null);
		if (visitaExistente != null) {
			visitaExistente.setId_bar(visita.getId_bar());
			visitaExistente.setId_cliente(visita.getId_cliente());
			visitaExistente.setId_empleado(visita.getId_empleado());
			visitaExistente.setFechaCreacion(visita.getFechaCreacion());
			visitaExistente.setValorCompra(visita.getValorCompra());
			repo.save(visitaExistente);
		}
	}

	public List<Visita> obtenerTodasLasVisitas() {
		return repo.findAll();
	}
	
	
}
