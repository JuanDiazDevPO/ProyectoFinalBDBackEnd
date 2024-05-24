package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	
	public Optional<List<Empleado>> findById(long id);
	public Optional<List<Empleado>> findByNombre(String nombre);
	Optional<Empleado> findByUsuario(String usuario);

}