package cl.ndt.sir.model;

public class Rol {
	/*
	 *   
  ID_ROL       INTEGER                          NOT NULL,
  ID_EMPRESA   INTEGER                          NOT NULL,
  NOMBRE       VARCHAR2(32 CHAR),
  DESCRIPCION  VARCHAR2(64 CHAR),
  ESTADO       INTEGER
  */
	private Integer id;
	private String nombre;
	private Empresa empresa;
	private String descripcion;
	
	public Rol(){
		
	}
	public Rol(Integer id){
		this.id=id;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	private boolean estado;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		String str = "id = ["+id+"]" +
				"nombre=["+nombre+"]" +
				"descripcion=["+descripcion+"]";
		return str;
	}
}
