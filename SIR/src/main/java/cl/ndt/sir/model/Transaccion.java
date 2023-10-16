package cl.ndt.sir.model;

public class Transaccion {

	private String empresa;
	private String identificador;
	private String amount;
	private String transactionOrder;	
	private String transactionType;	
	private String sucursal;
	private String estado;
	private String cardNumber;
	private String fechRegistro;
	private String detalleBuyOrder;
	private String detalleCommerceCode;
	private String detallepaymentTypeCode;
	private String fechaPago;
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTransactionOrder() {
		return transactionOrder;
	}
	public void setTransactionOrder(String transactionOrder) {
		this.transactionOrder = transactionOrder;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getFechRegistro() {
		return fechRegistro;
	}
	public void setFechRegistro(String fechRegistro) {
		this.fechRegistro = fechRegistro;
	}
	public String getDetalleBuyOrder() {
		return detalleBuyOrder;
	}
	public void setDetalleBuyOrder(String detalleBuyOrder) {
		this.detalleBuyOrder = detalleBuyOrder;
	}
	public String getDetalleCommerceCode() {
		return detalleCommerceCode;
	}
	public void setDetalleCommerceCode(String detalleCommerceCode) {
		this.detalleCommerceCode = detalleCommerceCode;
	}
	public String getDetallePaymentTypeCode() {
		return detallepaymentTypeCode;
	}
	public void setDetallePaymentTypeCode(String detallepaymentTypeCode) {
		this.detallepaymentTypeCode = detallepaymentTypeCode;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	
	
}
