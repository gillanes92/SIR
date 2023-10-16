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
import cl.ndt.sir.dao.UsuarioManager;
import cl.ndt.sir.model.Concentrador;
import cl.ndt.sir.model.DetallePago;
import cl.ndt.sir.model.Pago;
import cl.ndt.sir.model.Transaccion;
import cl.ndt.sir.model.Usuario;

public class TransaccionesController implements Controller{
	
protected final Log log = LogFactory.getLog(getClass());
	
	private UsuarioManager usuarioManager;
	private RendicionesDao rendicionesDao;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView(); 
		
		Usuario user = usuarioManager.obtenerUsuarioLogueado();
		
		log.info("USUARIO: "+user.getNombre());
		
		
		Map<String,Object> det = rendicionesDao.obtenerTransacciones(Integer.valueOf(user.getEmpresa().getId()));
		
		if(det.get("ncod_salida_out").equals("00")) {			
			
			List<Transaccion> list = (List<Transaccion>) det.get("cursor_out");
			modelAndView.addObject("transacciones", list);
			
		}
				
		Map<String,Object> mapa = new HashMap<String,Object>();
		log.info("usuario_logueado = ["+user.toString()+"]");
		mapa.put("usuario_logueado",user);
		modelAndView.addObject("map_usuario",mapa);
		modelAndView.setViewName("/pages/transacciones");		

		return modelAndView;
	}
	 
	public void setUsuarioManager(UsuarioManager usuarioManager){
		this.usuarioManager = usuarioManager;
	}
	
	public void setRendicionesDao(RendicionesDao rendicionesDao) {
		this.rendicionesDao = rendicionesDao;
	}

}
