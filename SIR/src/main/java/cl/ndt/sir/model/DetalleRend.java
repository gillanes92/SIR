package cl.ndt.sir.model;

public class DetalleRend {

	private Integer idDetalleRend;
	private String tipoTrans;
	private String fecVenta;
	private String tipoTarjeta;
	private String identificador;	
	private String codAutorizacion;
	private String monto;
	private String montoAnulacion;
	private String estadoConcilia;
	private Integer idPago;
	
	public Integer getIdDetalleRend() {
		return idDetalleRend;
	}
	public void setIdDetalleRend(Integer idDetalleRend) {
		this.idDetalleRend = idDetalleRend;
	}
	public String getTipoTrans() {
		return tipoTrans;
	}
	public void setTipoTrans(String tipoTrans) {
		this.tipoTrans = tipoTrans;
	}
	public String getFecVenta() {
		return fecVenta;
	}
	public void setFecVenta(String fecVenta) {
		this.fecVenta = fecVenta;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getCodAutorizacion() {
		return codAutorizacion;
	}
	public void setCodAutorizacion(String codAutorizacion) {
		this.codAutorizacion = codAutorizacion;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getMontoAnulacion() {
		return montoAnulacion;
	}
	public void setMontoAnulacion(String montoAnulacion) {
		this.montoAnulacion = montoAnulacion;
	}
	public String getEstadoConcilia() {
		return estadoConcilia;
	}
	public void setEstadoConcilia(String estadoConcilia) {
		this.estadoConcilia = estadoConcilia;
	}
	public Integer getIdPago() {
		return idPago;
	}
	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}
	
}
