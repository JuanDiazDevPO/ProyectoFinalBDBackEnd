package co.edu.unbosque.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.model.Auditoria;
import co.edu.unbosque.model.Bebida;
import co.edu.unbosque.repository.AuditoriaRepository;

@Service
public class AuditoriaService {

	@Autowired
	private AuditoriaRepository repository;

	public void registrarModificacion(String tablaModificada, Long idRegistroModificado, String tipoModificacion, String usuario, String datoAnterior, String datoNuevo) {
		Auditoria registro = new Auditoria();
		registro.setTablaModificada(tablaModificada);
		registro.setIdRegistroModificado(idRegistroModificado);
		registro.setTipoModificacion(tipoModificacion);
		registro.setFechaHoraModificacion(LocalDateTime.now());
		registro.setUsuario(usuario);
		registro.setDatoAnterior(datoAnterior);
		registro.setDatoNuevo(datoNuevo);
		repository.save(registro);
	}
	public List<Auditoria> obtenerTodasLasAuditorias() {
        return repository.findAll();
    }

}
