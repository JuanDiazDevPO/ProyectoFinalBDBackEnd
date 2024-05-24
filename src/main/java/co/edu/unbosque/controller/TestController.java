package co.edu.unbosque.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.model.Auditoria;
import co.edu.unbosque.model.Bar;
import co.edu.unbosque.model.Bebida;
import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.DetallePedido;
import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.Evento;
import co.edu.unbosque.model.Pedido;
import co.edu.unbosque.model.Puntos;
import co.edu.unbosque.model.Visita;
import co.edu.unbosque.repository.BarRepository;
import co.edu.unbosque.service.AuditoriaService;
import co.edu.unbosque.service.BarService;
import co.edu.unbosque.service.BebidaService;
import co.edu.unbosque.service.ClienteService;
import co.edu.unbosque.service.DetallePedidoService;
import co.edu.unbosque.service.EmpleadoService;
import co.edu.unbosque.service.EventoService;
import co.edu.unbosque.service.PedidoService;
import co.edu.unbosque.service.PuntosService;
import co.edu.unbosque.service.VisitaService;

@RestController
@RequestMapping(value = "/test")
@Transactional
@CrossOrigin(origins = {"http://localhost:8081","http://localhost:8080", "http://localhost:4200","*"})

//Obligatorias las 4 anotaciones

public class TestController {

	@Autowired
	private BarService barService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private BebidaService bebidaService;
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private DetallePedidoService detallePedidoService;
	@Autowired
	private EventoService eventoService;
	@Autowired
	private VisitaService visitaService;
	@Autowired
	private PuntosService puntosService;
	@Autowired
	private AuditoriaService auditoriaService;
	Empleado userlog;
	
	public TestController() {
		// TODO Auto-generated constructor stub 
	}

	@PostMapping(path="/registrarBar")
	public ResponseEntity<String> registrarBar(@RequestBody Bar b) {

		barService.agregarBar(b);
		auditoriaService.registrarModificacion("Bar", b.getId(), "Nuevo Bar", userlog.getUsuario(), null, b.getNombre());
		return new ResponseEntity<>("Bar: " + b.getNombre(), HttpStatus.CREATED);
	}
	@PostMapping("/logout")
	public ResponseEntity<String> logout() {
		userlog = null;
		return ResponseEntity.ok("Sesión cerrada exitosamente");
	}
	@PostMapping(path="/eliminarBar")
	public ResponseEntity<String> eliminarBar(@RequestBody Bar b) {
		barService.eliminarBar(b.getId());
		auditoriaService.registrarModificacion("Bar", b.getId(), "Eliminación Bar", userlog.getUsuario(), null, null);
		return new ResponseEntity<>("Ha eliminado el bar con id: " + b.getId(), HttpStatus.OK);
	}

	@PostMapping(path="/modificarBar")
	public ResponseEntity<String> modificarBar(@RequestBody Bar b) {
		barService.modificarBar(b);
		auditoriaService.registrarModificacion("Bar", b.getId(), "Modificación Bar", userlog.getUsuario(), b.getNombre(), b.getDireccion());
		return new ResponseEntity<>("Ha modificado el bar con id: " + b.getId(), HttpStatus.OK);
	}

	@GetMapping(path="/todosLosBares")
	public ResponseEntity<List<Bar>> obtenerTodosLosBares() {
		List<Bar> bares = barService.obtenerTodosLosBares();
		return new ResponseEntity<>(bares, HttpStatus.OK);
	}

	@PostMapping(path="/registrarEmpleado")
	public ResponseEntity<String> registrarEmpleado(@RequestBody Empleado e) {
		empleadoService.agregarEmpleado(e);
	//	auditoriaService.registrarModificacion("Empleado", e.getId(), "Nuevo Empleado", userlog.getUsuario(), null, e.getNombre());
		return new ResponseEntity<>("Empleado registrado correctamente", HttpStatus.CREATED);
	}

	@PostMapping(path="/eliminarEmpleado")
	public ResponseEntity<String> eliminarEmpleado(@RequestBody Empleado e) {
		empleadoService.eliminarEmpleado(e.getId());
		auditoriaService.registrarModificacion("Empleado", e.getId(), "Empleado eliminado", userlog.getUsuario(), null, null);
		return new ResponseEntity<>("Empleado eliminado con éxito", HttpStatus.OK);
	}

	@PostMapping(path="/modificarEmpleado")
	public ResponseEntity<String> modificarEmpleado(@RequestBody Empleado e) {
		empleadoService.modificarEmpleado(e);
		auditoriaService.registrarModificacion("Empleado", e.getId(), "Empleado modificado", userlog.getUsuario(), null, e.getNombre());
		return new ResponseEntity<>("Empleado modificado con éxito", HttpStatus.OK);
	}

	@GetMapping(path="/todosLosEmpleados")
	public ResponseEntity<List<Empleado>> obtenerTodosLosEmpleados() {
		List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}

	@PostMapping(path="/registrarCliente")
	public ResponseEntity<String> registrarCliente(@RequestBody Cliente c) {
		clienteService.agregarCliente(c);
		auditoriaService.registrarModificacion("Cliente", c.getId(), "Cliente nuevo", userlog.getUsuario(), null, c.getNombre());
		return new ResponseEntity<>("Cliente registrado correctamente", HttpStatus.CREATED);
	}

	@PostMapping(path="/eliminarCliente")
	public ResponseEntity<String> eliminarCliente(@RequestBody Cliente c) {
		clienteService.eliminarCliente(c.getId());
		auditoriaService.registrarModificacion("Cliente", c.getId(), "Cliente eliminado", userlog.getUsuario(), null, null);
		return new ResponseEntity<>("Cliente eliminado con éxito", HttpStatus.OK);
	}

	@PostMapping(path="/modificarCliente")
	public ResponseEntity<String> modificarCliente(@RequestBody Cliente c) {
		clienteService.modificarCliente(c);
		auditoriaService.registrarModificacion("Cliente", c.getId(), "Cliente modificado", userlog.getUsuario(), null, c.getNombre());
		return new ResponseEntity<>("Cliente modificado con éxito", HttpStatus.OK);
	}

	@GetMapping(path="/todosLosClientes")
	public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
		List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@PostMapping("/registrarBebida")
	public ResponseEntity<String> registrarBebida(@RequestBody Bebida bebida) {
		bebidaService.agregarBebida(bebida);
		auditoriaService.registrarModificacion("Bebida", bebida.getId(), "Bebida nueva", userlog.getUsuario(), null, bebida.getNombre());
		return new ResponseEntity<>("Bebida registrada correctamente", HttpStatus.CREATED);
	}

	@PostMapping("/eliminarBebida")
	public ResponseEntity<String> eliminarBebida(@RequestBody Bebida bebida) {
		bebidaService.eliminarBebida(bebida.getId());
		auditoriaService.registrarModificacion("Bebida", bebida.getId(), "Bebida eliminada", userlog.getUsuario(), null, null);
		return new ResponseEntity<>("Bebida eliminada con éxito", HttpStatus.OK);
	}

	@PostMapping("/modificarBebida")
	public ResponseEntity<String> modificarBebida(@RequestBody Bebida bebida) {
		bebidaService.modificarBebida(bebida);
		auditoriaService.registrarModificacion("Bebida", bebida.getId(), "Bebida modificada", userlog.getUsuario(), bebida.getNombre(), null);
		return new ResponseEntity<>("Bebida modificada con éxito", HttpStatus.OK);
	}

	@GetMapping("/todasLasBebidas")
	public ResponseEntity<List<Bebida>> obtenerTodasLasBebidas() {
		List<Bebida> bebidas = bebidaService.obtenerTodasLasBebidas();
		return new ResponseEntity<>(bebidas, HttpStatus.OK);
	}
	@GetMapping("/todasLasAuditorias")
	public ResponseEntity<List<Auditoria>> obtenerTodasLasAuditorias() {
		List<Auditoria> auditorias= auditoriaService.obtenerTodasLasAuditorias();
		return new ResponseEntity<>(auditorias, HttpStatus.OK);
	}
	@PostMapping("/registrarPedido")
	public ResponseEntity<String> registrarPedido(@RequestBody Pedido pedido) {
		pedidoService.agregarPedido(pedido);
		auditoriaService.registrarModificacion("Pedido", pedido.getId(), "Pedido nuevo", userlog.getUsuario(), null, null);
		return new ResponseEntity<>("Pedido registrado correctamente", HttpStatus.CREATED);
	}

	@PostMapping("/eliminarPedido")
	public ResponseEntity<String> eliminarPedido(@RequestBody Pedido pedido) {
		pedidoService.eliminarPedido(pedido.getId());
		auditoriaService.registrarModificacion("Pedido", pedido.getId(), "Pedido eliminado", userlog.getUsuario(), null, null);
		return new ResponseEntity<>("Pedido eliminado con éxito", HttpStatus.OK);
	}

	@PostMapping("/modificarPedido")
	public ResponseEntity<String> modificarPedido(@RequestBody Pedido pedido) {
		pedidoService.modificarPedido(pedido);
		auditoriaService.registrarModificacion("Pedido", pedido.getId(), "Pedido modificado", userlog.getUsuario(), null, null);
		return new ResponseEntity<>("Pedido modificado con éxito", HttpStatus.OK);
	}

	@GetMapping("/todosLosPedidos")
	public ResponseEntity<List<Pedido>> obtenerTodosLosPedidos() {
		List<Pedido> pedidos = pedidoService.obtenerTodosLosPedidos();
		return new ResponseEntity<>(pedidos, HttpStatus.OK);
	}
	
	@PostMapping("/registrarDetallePedido")
	public ResponseEntity<String> registrarDetallePedido(@RequestBody DetallePedido dp) {
	    detallePedidoService.agregarDetallePedido(dp);
	    auditoriaService.registrarModificacion("Detalle Pedido", dp.getId(), "Detalle pedido nuevo", userlog.getUsuario(), null, null);
	    return new ResponseEntity<>("Detalle de pedido registrado correctamente", HttpStatus.CREATED);
	}

	@PostMapping("/eliminarDetallePedido")
	public ResponseEntity<String> eliminarDetallePedido(@RequestParam Long id) {
	    detallePedidoService.eliminarDetallePedido(id);
	    auditoriaService.registrarModificacion("Detalle Pedido", id, "Detalle pedido eliminado", userlog.getUsuario(), null, null);
	    return new ResponseEntity<>("Detalle de pedido eliminado con éxito", HttpStatus.OK);
	}

	@PostMapping("/modificarDetallePedido")
	public ResponseEntity<String> modificarDetallePedido(@RequestBody DetallePedido dp) {
	    detallePedidoService.modificarDetallePedido(dp);
	    auditoriaService.registrarModificacion("Detalle Pedido", dp.getId(), "Detalle pedido modificado", userlog.getUsuario(), null, null);
	    return new ResponseEntity<>("Detalle de pedido modificado con éxito", HttpStatus.OK);
	}

	@GetMapping("/todosLosDetallesPedidos")
	public ResponseEntity<List<DetallePedido>> obtenerTodosLosDetallesPedidos() {
	    List<DetallePedido> detallesPedidos = detallePedidoService.obtenerTodosLosDetallesPedido();
	    return new ResponseEntity<>(detallesPedidos, HttpStatus.OK);
	}

	@PostMapping("/registrarEvento")
	public ResponseEntity<String> registrarEvento(@RequestBody Evento e) {
	    eventoService.agregarEvento(e);
	    auditoriaService.registrarModificacion("Evento", e.getId(), "Evento nuevo", userlog.getUsuario(), null, null);
	    return new ResponseEntity<>("Evento registrado correctamente", HttpStatus.CREATED);
	}

	@PostMapping("/eliminarEvento")
	public ResponseEntity<String> eliminarEvento(@RequestBody Evento e) {
	    eventoService.eliminarEvento(e.getId());
	    auditoriaService.registrarModificacion("Evento", e.getId(), "Evento eliminado", userlog.getUsuario(), null, null);
	    return new ResponseEntity<>("Evento eliminado con éxito", HttpStatus.OK);
	}

	@PostMapping("/modificarEvento")
	public ResponseEntity<String> modificarEvento(@RequestBody Evento e) {
	    eventoService.modificarEvento(e);
	    auditoriaService.registrarModificacion("Evento", e.getId(), "Evento modificado", userlog.getUsuario(), null, null);
	    return new ResponseEntity<>("Evento modificado con éxito", HttpStatus.OK);
	}

	@GetMapping("/todosLosEventos")
	public ResponseEntity<List<Evento>> obtenerTodosLosEventos() {
	    List<Evento> eventos = eventoService.obtenerTodosLosEventos();
	    return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
	
	@PostMapping("/registrarVisita")
	public ResponseEntity<String> registrarVisita(@RequestBody Visita v) {
	    visitaService.agregarVisita(v);
	    auditoriaService.registrarModificacion("Visita", v.getId(), "Visita nueva", userlog.getUsuario(), null, null);
	    puntosService.actualizarPuntos(v);
	    auditoriaService.registrarModificacion("Puntos", v.getId(), "Modificación puntos", userlog.getUsuario(), null, null);
	    return new ResponseEntity<>("Visita registrada correctamente", HttpStatus.CREATED);
	}

	@PostMapping("/eliminarVisita")
	public ResponseEntity<String> eliminarVisita(@RequestBody Visita v) {
	    visitaService.eliminarVisita(v.getId());
	    auditoriaService.registrarModificacion("Visita", v.getId(), "Visita eliminada", userlog.getUsuario(), null, null);
	    return new ResponseEntity<>("Visita eliminada con éxito", HttpStatus.OK);
	}

	@PostMapping("/modificarVisita")
	public ResponseEntity<String> modificarVisita(@RequestBody Visita v) {
	    visitaService.modificarVisita(v);
	    auditoriaService.registrarModificacion("Visita", v.getId(), "Visita modificada", userlog.getUsuario(), null, null);
	    return new ResponseEntity<>("Visita modificada con éxito", HttpStatus.OK);
	}

	@GetMapping("/todasLasVisitas")
	public ResponseEntity<List<Visita>> obtenerTodasLasVisitas() {
	    List<Visita> visitas = visitaService.obtenerTodasLasVisitas();
	    return new ResponseEntity<>(visitas, HttpStatus.OK);
	}
	
	@GetMapping("/todosLosPuntos")
	public ResponseEntity<List<Puntos>> obtenerTodosLosPuntos() {
	    List<Puntos> puntos = puntosService.obtenerTodosLosPuntos();
	    return new ResponseEntity<>(puntos, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Empleado> login(@RequestBody Empleado empleado) {
	    boolean empleadoAutenticado = empleadoService.login(empleado.getUsuario(), empleado.getContrasena());
	    if (empleadoAutenticado) {
	        Optional<Empleado> empleadoEncontrado = empleadoService.findByUsuario(empleado.getUsuario());
	        if (empleadoEncontrado.isPresent()) {
	            Empleado empleadoLoggeado = empleadoEncontrado.get();
	            userlog = empleadoLoggeado;
	            return ResponseEntity.ok(empleadoLoggeado);
	        }
	    }
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}




}
