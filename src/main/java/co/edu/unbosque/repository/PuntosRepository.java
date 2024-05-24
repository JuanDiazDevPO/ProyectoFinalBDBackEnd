package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.model.Puntos;

public interface PuntosRepository extends JpaRepository<Puntos, Long>{
	
	public Puntos findById(long id);

}