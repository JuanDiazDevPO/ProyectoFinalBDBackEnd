package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.model.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Long>{
	
	public Optional<List<Visita>> findById(double id);

}