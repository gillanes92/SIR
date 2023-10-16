package cl.ndt.sir.model;

public class Rendicion {

	private Integer idRendicion;
	private String codigoComercio;
	private String nombreFantasia;
	private String producto;
	private String fechaAbono;
	private String fechaRendicion;
	private Integer cantidad;
	private Integer conciliadas;
	private String estado;
	private String image;
	
	public Integer getIdRendicion() {
		return idRendicion;
	}
	public void setIdRendicion(Integer idRendicion) {
		this.idRendicion = idRendicion;
	}
	public String getCodigoComercio() {
		return codigoComercio;
	}
	public void setCodigoComercio(String codigoComercio) {
		this.codigoComercio = codigoComercio;
	}
	public String getNombreFantasia() {
		return nombreFantasia;
	}
	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getFechaAbono() {
		return fechaAbono;
	}
	public void setFechaAbono(String fechaAbono) {
		this.fechaAbono = fechaAbono;
	}
	public String getFechaRendicion() {
		return fechaRendicion;
	}
	public void setFechaRendicion(String fechaRendicion) {
		this.fechaRendicion = fechaRendicion;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
