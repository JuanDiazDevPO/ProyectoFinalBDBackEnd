package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.model.Bar;

public interface BarRepository extends JpaRepository<Bar, Long>{
	
	public Bar findById(double id);
	public Optional<List<Bar>> findByNombre(String nombre);

}
