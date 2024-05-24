package co.edu.unbosque.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public ClienteService() {
        // TODO Auto-generated constructor stub
    }

    public void agregarCliente(Cliente c) {
        repo.save(c);
    }

    public void eliminarCliente(Long id) {
        repo.deleteById(id);
    }

    public void modificarCliente(Cliente c) {
        Cliente cliente = repo.findById(c.getId()).orElse(null);
        if (cliente != null) {
            cliente.setNombre(c.getNombre());
            cliente.setDireccion(c.getDireccion());
            cliente.setTelefono(c.getTelefono());
            repo.save(cliente);
        }
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return repo.findAll();
    }

    public Optional<List<Cliente>> buscarClientePorNombre(String nombre) {
        return repo.findByNombre(nombre);
    }
}
