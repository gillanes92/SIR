package cl.ndt.sir.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import cl.ndt.sir.dao.RolDao;
import cl.ndt.sir.dao.UsuarioDao;
import cl.ndt.sir.dao.UsuarioManager;
import cl.ndt.sir.model.Rol;
import cl.ndt.sir.model.Usuario;

public class UsuarioManagerImpl  implements UsuarioManager{
	
	private Logger log = (Logger) Logger.getLogger(this.getClass());
	private UsuarioDao usuarioDao;
	private RolDao rolDao;
	
	private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
	
	public void setUsuarioDao(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
	
	public void setRolDao(RolDao rolDao){
		this.rolDao = rolDao;
	}
	
	public Usuario obtenerUsuarioLogueado() {

			Usuario usuario = null;
			
			log.info("iniciando obtenerUsuarioLogueado");
			
 			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			if ( auth==null ){
				return usuario;
				
			}else{
	 
			String user = SecurityContextHolder.getContext().getAuthentication().getName();
			
			log.info("nombre usuario = ["+user+"]");
			//user = user.substring(0,user.indexOf("@"));
			
			Map<String,Object> mapa  = usuarioDao.obtenerUsuarioPorNombre(user);
			if(mapa!=null &&  mapa.get("usuario")!=null){
				usuario = (Usuario) mapa.get("usuario");
			}
			if(usuario!=null){
				log.info("id_usuario = "+usuario.getId()+"");
			}else{
				log.info("usuario es null");
				return new Usuario(-1);
			}
		return usuario;
		
			}
	}

	public Rol obtenerRolDeUsuarioLogueado() {
		
		String userContext = SecurityContextHolder.getContext().getAuthentication().getName();
		String user = userContext.substring(0,userContext.indexOf("@"));
		String empresa = userContext.substring(userContext.indexOf("@")+1);
		Map<String,Object> mapa = rolDao.obtenerRol(user, empresa);
		
		return (Rol)mapa.get("rol");
	}

}
