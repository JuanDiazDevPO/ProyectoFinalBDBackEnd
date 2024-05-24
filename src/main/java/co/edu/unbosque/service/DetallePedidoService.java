package co.edu.unbosque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.model.DetallePedido;
import co.edu.unbosque.repository.DetallePedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository repo;

    public DetallePedidoService() {
        // TODO Auto-generated constructor stub
    }

    public void agregarDetallePedido(DetallePedido detallePedido) {
        repo.save(detallePedido);
    }

    public void eliminarDetallePedido(Long id) {
        repo.deleteById(id);
    }

    public void modificarDetallePedido(DetallePedido detallePedido) {
        DetallePedido detalle = repo.findById(detallePedido.getId()).orElse(null);
        if (detalle != null) {
            detalle.setCantidad(detallePedido.getCantidad());
            detalle.setId_bebida(detallePedido.getId_bebida());
            detalle.setId_pedido(detallePedido.getId_pedido());
            repo.save(detalle);
        }
    }

    public List<DetallePedido> obtenerTodosLosDetallesPedido() {
        return repo.findAll();
    }


}
