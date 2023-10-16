package cl.ndt.sir.dao.Impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import cl.ndt.sir.dao.UsuarioDao;
import cl.ndt.sir.dao.Impl.storedProcedure.RegisterUsuarioStoredProcedure;
import cl.ndt.sir.dao.Impl.storedProcedure.UsuarioInsertHistoricolLoginStoredProcedure;
import cl.ndt.sir.dao.Impl.storedProcedure.UsuarioObtenerStoredProcedure;
import cl.ndt.sir.utils.MyDelegatingDS;

public class UsuarioDaoImpl  implements UsuarioDao {
    
	private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }

	@Override
	public Map<String, Object> obtenerUsuarioPorNombre(String nombre) {
		
		MyDelegatingDS ds = new MyDelegatingDS(false, this.dataSource);
 
		UsuarioObtenerStoredProcedure usuarioObtener = new UsuarioObtenerStoredProcedure(ds);
		
		try{
			return usuarioObtener.execute(null, nombre);
		} catch(Exception e){
			return new HashMap<String,Object>();
		}
	}

	@Override
	public Map<String, Object> registrarUsuario(String nombre, String password, String correo, Integer id_empresa) {
		// TODO Auto-generated method stub
		MyDelegatingDS ds = new MyDelegatingDS(true, this.dataSource);
		
		RegisterUsuarioStoredProcedure sp = new RegisterUsuarioStoredProcedure(ds);
		
		try {
			return sp.execute(nombre, password, correo, id_empresa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new HashMap<String,Object>();
		}		
	}
	
	@Override
	public Map<String, Object> ingresarHistoricoLogin(Integer usuario, String accion) {
		MyDelegatingDS ds = new MyDelegatingDS(true, this.dataSource);
		UsuarioInsertHistoricolLoginStoredProcedure sp = new UsuarioInsertHistoricolLoginStoredProcedure(ds);
		try {
			return sp.execute(usuario, accion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new HashMap<String,Object>();
		}
	}
	

}
