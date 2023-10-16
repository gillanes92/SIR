package cl.ndt.sir.model;

import java.util.Date;

public class HistoricoLogin {
	private Integer id;
	private Integer idUsuario;
	private String accion;
	private Date fecha;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUsuario() {
		return idUsuario;
	}
	public void setUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
