package co.edu.unbosque.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.model.Bebida;
import co.edu.unbosque.repository.BebidaRepository;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository repo;

    public BebidaService() {
        // Constructor
    }

    public void agregarBebida(Bebida bebida) {
        repo.save(bebida);
    }
   
    public void eliminarBebida(Long id) {
        repo.deleteById(id);
    }

    public void modificarBebida(Bebida bebida) {
        Bebida bebidaEncontrada = repo.findById(bebida.getId()).orElse(null);
        if (bebidaEncontrada != null) {
            bebidaEncontrada.setNombre(bebida.getNombre());
            bebidaEncontrada.setTipo(bebida.getTipo());
            bebidaEncontrada.setStock(bebida.getStock());
            bebidaEncontrada.setPrecio(bebida.getPrecio());
            repo.save(bebidaEncontrada);
        }
    }

    public List<Bebida> obtenerTodasLasBebidas() {
        return repo.findAll();
    }

    public Optional<List<Bebida>> buscarBebidaPorNombre(String nombre) {
        return repo.findByNombre(nombre);
    }
}
