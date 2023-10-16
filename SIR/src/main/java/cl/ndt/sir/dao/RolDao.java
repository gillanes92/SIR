package cl.ndt.sir.dao;

import java.util.List;
import java.util.Map;

import cl.ndt.sir.model.Empresa;
import cl.ndt.sir.model.Rol;
import cl.ndt.sir.model.Usuario;
 

public interface RolDao {

	public Map<String,Object> ingresarRol(Rol rol , Integer id_usuario);
	public Map<String,Object> editarRol(Rol rol , Integer id_usuario);
	public Map<String,Object> obtenerRol(Usuario usuario, Empresa empresa);
	public Map<String,Object> obtenerRol(String usuario, String empresa);
	public List<Rol> obtenerRoles(Integer id_rol, Integer usuarioID);
	public Map<String,Object> obtenerRol(Integer id);
	
}
