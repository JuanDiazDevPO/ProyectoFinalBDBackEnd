package co.edu.unbosque.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.model.Evento;
import co.edu.unbosque.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repo;

	public void agregarEvento(Evento evento) {
		repo.save(evento);
	}

	public void eliminarEvento(Long id) {
		repo.deleteById(id);
	}

	public void modificarEvento(Evento evento) {
		Evento evt = repo.findById(evento.getId()).orElse(null);
		if (evt != null) {
			evt.setId_bar(evento.getId_bar());
			evt.setId_cliente(evento.getId_cliente());
			evt.setId_empleado(evento.getId_empleado());
			evt.setFecha(evento.getFecha());
			evt.setHora(evento.getHora());
			evt.setPrecio(evento.getPrecio());
			evt.setCantidadpersonas(evento.getCantidadpersonas());
			repo.save(evt);
		}
	}

	public Optional<List<Evento>> buscarEventosPorFecha(String fecha) {
		return repo.findByFecha(fecha);
	}

	public List<Evento> obtenerTodosLosEventos() {
		return repo.findAll();
	}
}
