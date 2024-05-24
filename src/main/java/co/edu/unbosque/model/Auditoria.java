package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tablaModificada;
    private Long idRegistroModificado;
    private String tipoModificacion;
    private LocalDateTime fechaHoraModificacion;
    private String usuario;
    private String datoAnterior;
    private String datoNuevo;
    
    public Auditoria() {
		// TODO Auto-generated constructor stub
	}



	public Auditoria(Long id, String tablaModificada, Long idRegistroModificado, String tipoModificacion,
			LocalDateTime fechaHoraModificacion, String usuario, String datoAnterior, String datoNuevo) {
		super();
		this.id = id;
		this.tablaModificada = tablaModificada;
		this.idRegistroModificado = idRegistroModificado;
		this.tipoModificacion = tipoModificacion;
		this.fechaHoraModificacion = fechaHoraModificacion;
		this.usuario = usuario;
		this.datoAnterior = datoAnterior;
		this.datoNuevo = datoNuevo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTablaModificada() {
		return tablaModificada;
	}

	public void setTablaModificada(String tablaModificada) {
		this.tablaModificada = tablaModificada;
	}

	public Long getIdRegistroModificado() {
		return idRegistroModificado;
	}

	public void setIdRegistroModificado(Long idRegistroModificado) {
		this.idRegistroModificado = idRegistroModificado;
	}

	public String getTipoModificacion() {
		return tipoModificacion;
	}

	public void setTipoModificacion(String tipoModificacion) {
		this.tipoModificacion = tipoModificacion;
	}

	public LocalDateTime getFechaHoraModificacion() {
		return fechaHoraModificacion;
	}

	public void setFechaHoraModificacion(LocalDateTime fechaHoraModificacion) {
		this.fechaHoraModificacion = fechaHoraModificacion;
	}

	public String getDatoAnterior() {
		return datoAnterior;
	}

	public void setDatoAnterior(String datoAnterior) {
		this.datoAnterior = datoAnterior;
	}

	public String getDatoNuevo() {
		return datoNuevo;
	}

	public void setDatoNuevo(String datoNuevo) {
		this.datoNuevo = datoNuevo;
	}

	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	@Override
	public int hashCode() {
		return Objects.hash(datoAnterior, datoNuevo, fechaHoraModificacion, id, idRegistroModificado, tablaModificada,
				tipoModificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditoria other = (Auditoria) obj;
		return Objects.equals(datoAnterior, other.datoAnterior) && Objects.equals(datoNuevo, other.datoNuevo)
				&& Objects.equals(fechaHoraModificacion, other.fechaHoraModificacion) && Objects.equals(id, other.id)
				&& Objects.equals(idRegistroModificado, other.idRegistroModificado)
				&& Objects.equals(tablaModificada, other.tablaModificada)
				&& Objects.equals(tipoModificacion, other.tipoModificacion);
	}
    
    

   
}
