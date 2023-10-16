package cl.ndt.sir.dao;

import java.util.Map;


public interface UsuarioDao {
	
	public Map<String,Object> obtenerUsuarioPorNombre(String nombre);
	public Map<String,Object> registrarUsuario(String nombre, String password, String correo, Integer id_empresa);
	public Map<String, Object> ingresarHistoricoLogin(Integer usuario, String accion);
	

}
