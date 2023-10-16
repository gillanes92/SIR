package cl.ndt.sir.model;

public class Empresa {

	private Integer id;
	private String nombre;
	private String contacto;
	private String direccion;
	private String telefono;
	private String rut;
	private boolean estado;
	private Integer superUsuario;
	
	public Empresa(){
		
	}
	public Empresa(Integer id){
		this.id=id;
	}
	
	
	@Override
	public String toString() {
		String str = "id=["+id+"]nombre=["+nombre+"]contacto=["+contacto+"]direccion["+direccion+"]telefono["+telefono+"]rut=["+rut+"]"+"estado["+estado+"]";
		return str;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Integer getSuperUsuario() {
		return superUsuario;
	}
	public void setSuperUsuario(Integer superUsuario) {
		this.superUsuario = superUsuario;
	}
	
}
