package cl.ndt.sir.model;

public class DetallePago {

	private Integer idDetallePago;
	private String identificador;
	private String montoPago;
	private String tipoTarjeta;	
	private String codAutorizacion;	
	private String fechaVenta;
	private String estadoConcilia;
	private Integer idRend;
	
	public Integer getIdDetallePago() {
		return idDetallePago;
	}
	public void setIdDetallePago(Integer idDetallePago) {
		this.idDetallePago = idDetallePago;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getMontoPago() {
		return montoPago;
	}
	public void setMontoPago(String montoPago) {
		this.montoPago = montoPago;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public String getCodAutorizacion() {
		return codAutorizacion;
	}
	public void setCodAutorizacion(String codAutorizacion) {
		this.codAutorizacion = codAutorizacion;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getEstadoConcilia() {
		return estadoConcilia;
	}
	public void setEstadoConcilia(String estadoConcilia) {
		this.estadoConcilia = estadoConcilia;
	}
	public Integer getIdRend() {
		return idRend;
	}
	public void setIdRend(Integer idRend) {
		this.idRend = idRend;
	}
	
	
	
}
