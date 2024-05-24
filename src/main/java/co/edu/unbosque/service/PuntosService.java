package co.edu.unbosque.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.unbosque.model.Puntos;
import co.edu.unbosque.model.Visita;
import co.edu.unbosque.repository.PuntosRepository;

@Service
public class PuntosService {

	@Autowired
	private PuntosRepository repo;

	public PuntosService() {
		// TODO Auto-generated constructor stub
	}

	public void agregarPuntos(Puntos puntos) {
		repo.save(puntos);
	}

	public void eliminarPuntos(Long id) {
		repo.deleteById(id);
	}

	public void modificarPuntos(Puntos puntos) {
		Puntos puntosDb = repo.findById(puntos.getId()).orElse(null);
		if (puntosDb != null) {
			puntosDb.setId_cliente(puntos.getId_cliente());
			puntosDb.setCantidad(puntos.getCantidad());
			puntosDb.setUltimaRedencion(puntos.getUltimaRedencion());
			repo.save(puntosDb);
		}
	}

	public void actualizarPuntos(Visita v) {
		Puntos puntosDb = repo.findById(v.getId_cliente());
		if (puntosDb != null) {
			puntosDb.setCantidad((int) (v.getValorCompra()/1000));
			puntosDb.setUltimaRedencion(LocalDateTime.now());
		}else {
			Puntos crear = new Puntos(null, v.getId_cliente(), 0, LocalDateTime.now());
			agregarPuntos(crear);
		}




	}

	public List<Puntos> obtenerTodosLosPuntos() {
		return repo.findAll();
	}
}
