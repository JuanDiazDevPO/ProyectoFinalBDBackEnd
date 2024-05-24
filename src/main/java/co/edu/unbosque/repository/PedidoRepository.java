package co.edu.unbosque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import co.edu.unbosque.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	public Optional<List<Pedido>> findById(double id);

}