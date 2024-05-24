package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
	
	public Optional<List<Evento>> findById(double id);
	public Optional<List<Evento>> findByFecha(String fecha);

}
