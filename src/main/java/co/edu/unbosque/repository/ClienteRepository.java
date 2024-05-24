package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.model.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Optional<List<Cliente>> findById(double id);
	public Optional<List<Cliente>> findByNombre(String nombre);

}