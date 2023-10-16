package cl.ndt.sir.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import cl.ndt.sir.dao.RolDao;
import cl.ndt.sir.dao.UsuarioManager;
import cl.ndt.sir.model.Empresa;
import cl.ndt.sir.model.Rol;
import cl.ndt.sir.model.Usuario;

public class RolDaoImpl implements RolDao{

	private DataSource dataSource;
	private Logger log = (Logger) Logger.getLogger(this.getClass());
	private RolDao rolDao;
	private UsuarioManager usuarioManager;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@Override
	public Map<String, Object> ingresarRol(Rol rol, Integer id_usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> editarRol(Rol rol, Integer id_usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> obtenerRol(Usuario usuario, Empresa empresa) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> obtenerRol(String usuario, String empresa) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Rol> obtenerRoles(Integer id_rol, Integer usuarioID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> obtenerRol(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
