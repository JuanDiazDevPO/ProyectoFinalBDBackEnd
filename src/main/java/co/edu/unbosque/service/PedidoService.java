package co.edu.unbosque.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.model.Pedido;
import co.edu.unbosque.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public PedidoService() {
        // TODO Auto-generated constructor stub
    }

    public void agregarPedido(Pedido p) {
        p.setFechaCreacion(LocalDateTime.now());
        repo.save(p);
    }

    public void eliminarPedido(Long id) {
        repo.deleteById(id);
    }

    public void modificarPedido(Pedido p) {
        Pedido pedido = repo.findById(p.getId()).orElse(null);
        if (pedido != null) {
            pedido.setId_bar(p.getId_bar());
            pedido.setId_cliente(p.getId_cliente());
            pedido.setFechaCreacion(LocalDateTime.now());
            repo.save(pedido);
        }
    }

    public List<Pedido> obtenerTodosLosPedidos() {
        return repo.findAll();
    }
}
