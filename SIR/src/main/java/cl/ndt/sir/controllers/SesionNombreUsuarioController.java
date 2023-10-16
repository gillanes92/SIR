package cl.ndt.sir.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cl.ndt.sir.dao.UsuarioManager;
import cl.ndt.sir.model.Usuario;


public class SesionNombreUsuarioController  implements Controller{

	private UsuarioManager usuarioManager;
	private Logger log = (Logger) Logger.getLogger(this.getClass());
 
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		log.info("iniciando SesionNombreUsuarioController");
		Usuario usuario = usuarioManager.obtenerUsuarioLogueado();
		Map<String,Object> mapa = new HashMap<String,Object>();
		if(usuario!=null){
			log.info("usuario_logueado = ["+usuario.toString()+"]");
		}else{
			log.info("usuario_logueado = [null]");
		}
		mapa.put("usuario_logueado",usuario);
		return new ModelAndView("header","map_usuario",mapa);
	}
	
	public void setUsuarioManager(UsuarioManager usuarioManager){
		this.usuarioManager = usuarioManager;
	}
	
}
