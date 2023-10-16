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
import cl.ndt.sir.model.DetallePago;
import cl.ndt.sir.model.Usuario;

public class DetalleTransaccionController implements Controller{

protected final Log log = LogFactory.getLog(getClass());
	
	private UsuarioManager usuarioManager;
	private RendicionesDao rendicionesDao;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView(); 
		
		Usuario user = usuarioManager.obtenerUsuarioLogueado();
		
		log.info("USUARIO: "+user.getNombre());
		
		String idRend = request.getParameter("idPago");
		
		if(idRend==null || idRend.isEmpty()) {
			response.sendRedirect("home.htm");
		}
		
		Map<String,Object> det = rendicionesDao.obtenerDetallesPago(Integer.valueOf(idRend));
		
		if(det.get("ncod_salida_out").equals("00")) {			
			
			List<DetallePago> list = (List<DetallePago>) det.get("cur_det_rend_out");
			modelAndView.addObject("detallesTransaccion", list);
			
		}
				
		Map<String,Object> mapa = new HashMap<String,Object>();
		log.info("usuario_logueado = ["+user.toString()+"]");
		mapa.put("usuario_logueado",user);
		modelAndView.addObject("map_usuario",mapa);
		modelAndView.setViewName("/pages/detalleTransaccion");		

		return modelAndView;
	}
	 
	public void setUsuarioManager(UsuarioManager usuarioManager){
		this.usuarioManager = usuarioManager;
	}
	
	public void setRendicionesDao(RendicionesDao rendicionesDao) {
		this.rendicionesDao = rendicionesDao;
	}
	
}
