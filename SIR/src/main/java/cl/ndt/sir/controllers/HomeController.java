package cl.ndt.sir.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cl.ndt.sir.dao.UsuarioDao;
import cl.ndt.sir.dao.UsuarioManager;
import cl.ndt.sir.model.Usuario;

public class HomeController implements Controller {

	protected final Log log = LogFactory.getLog(getClass());
	
	private UsuarioManager usuarioManager;
	private UsuarioDao usuarioDao;
	 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
 
		Usuario user = usuarioManager.obtenerUsuarioLogueado();
		
		usuarioDao.ingresarHistoricoLogin(user.getId(), "Login");
		
		log.info("USUARIO: "+user.getNombre());
		
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> mapa = new HashMap<String,Object>();
		if(user!=null){
			log.info("usuario_logueado = ["+user.toString()+"]");
		}else{
			log.info("usuario_logueado = [null]");
		}
		mapa.put("usuario_logueado",user);
		modelAndView.addObject("map_usuario",mapa);
		modelAndView.setViewName("/pages/home");		

		return modelAndView;
	}
	 
	public void setUsuarioManager(UsuarioManager usuarioManager){
		this.usuarioManager = usuarioManager;
	}
	 
	public void setUsuarioDao(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
}
