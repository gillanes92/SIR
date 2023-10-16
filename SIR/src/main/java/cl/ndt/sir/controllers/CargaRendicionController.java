package cl.ndt.sir.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cl.ndt.sir.dao.RendicionesDao;
import cl.ndt.sir.dao.UsuarioDao;
import cl.ndt.sir.dao.UsuarioManager;
import cl.ndt.sir.model.Concentrador;
import cl.ndt.sir.model.Rendicion;
import cl.ndt.sir.model.Usuario;

public class CargaRendicionController implements Controller {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private UsuarioManager usuarioManager;
	private RendicionesDao rendicionesDao;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 
		Usuario user = usuarioManager.obtenerUsuarioLogueado();
		
		log.info("USUARIO: "+user.getNombre());
		
		ModelAndView modelAndView = new ModelAndView();
		
		Map<String,Object> concentradores = rendicionesDao.concentradores();
		
		if(concentradores.get("ncod_salida_out").equals("00")) {
			List<Concentrador> list = (List<Concentrador>) concentradores.get("cur_con");
			modelAndView.addObject("concentradores", list);
		}
		
		Map<String,Object> rend = rendicionesDao.listarRendiciones(user.getEmpresa().getId());
		
		if(rend.get("ncod_salida_out").equals("00")) {
			List<Rendicion> list = (List<Rendicion>) rend.get("cur_usuario_out");
			modelAndView.addObject("rendiciones", list);
		}
		
		Map<String,Object> mapa = new HashMap<String,Object>();
		log.info("usuario_logueado = ["+user.toString()+"]");
		mapa.put("usuario_logueado",user);
		modelAndView.addObject("map_usuario",mapa);
		modelAndView.setViewName("/pages/cargaRendiciones");		

		return modelAndView;
	}
	 
	public void setUsuarioManager(UsuarioManager usuarioManager){
		this.usuarioManager = usuarioManager;
	}
	
	public void setRendicionesDao(RendicionesDao rendicionesDao) {
		this.rendicionesDao = rendicionesDao;
	}

}
