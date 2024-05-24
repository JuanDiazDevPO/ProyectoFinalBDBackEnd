package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.model.Bebida;

public interface BebidaRepository extends JpaRepository<Bebida, Long>{
	
	public Optional<List<Bebida>> findById(double id);
	public Optional<List<Bebida>> findByNombre(String nombre);

}