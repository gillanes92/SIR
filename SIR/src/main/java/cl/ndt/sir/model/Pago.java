package cl.ndt.sir.model;

public class Pago {

	private Integer idPago;
	private String archivoOriginal;
	private String fechaSubida;
	private Integer cantidad;
	private Integer conciliadas;
	private String estado;
	
	public Integer getIdPago() {
		return idPago;
	}
	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}	
	public String getArchivoOriginal() {
		return archivoOriginal;
	}
	public void setArchivoOriginal(String archivoOriginal) {
		this.archivoOriginal = archivoOriginal;
	}
	public String getFechaSubida() {
		return fechaSubida;
	}
	public void setFechaSubida(String fechaSubida) {
		this.fechaSubida = fechaSubida;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getConciliadas() {
		return conciliadas;
	}
	public void setConciliadas(Integer conciliadas) {
		this.conciliadas = conciliadas;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
