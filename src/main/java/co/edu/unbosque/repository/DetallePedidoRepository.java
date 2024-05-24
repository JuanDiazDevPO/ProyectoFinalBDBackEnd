package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long>{
	
	public Optional<List<DetallePedido>> findById(long id);



}
