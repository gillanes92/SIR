package cl.ndt.sir.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cl.ndt.sir.dao.UsuarioDao;
import net.sf.json.JSONArray;


public class ServiceLoginController implements Controller{
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private UsuarioDao usuarioDao;
	
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONArray array = null;
		Map<String,Object> respuesta = new HashMap<String,Object>();
		Map<String,Object> outParameterA = new HashMap<String,Object>();
		Map<String,Integer> metodos = new HashMap<String,Integer>();
		
		metodos.put("registrarUsuario", 0);
		 
		String metodo = request.getParameter("metodo");
		
		switch (metodos.get(metodo)) {
			case 0:
				outParameterA = registrarUsuario(request, response);				 
				break;
		}
		 
		array = JSONArray.fromObject(outParameterA);
		respuesta.put("json_respuesta", array); 
		
		ModelAndView modelAndView = new ModelAndView("/servicios/servicio_login", "mapa", respuesta);
	    return modelAndView;
		
	 }

	private Map<String,Object> registrarUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("name");
		String password = request.getParameter("password");
		String correo = request.getParameter("email");
		return usuarioDao.registrarUsuario(nombre, password, correo, 1);		
	}
	
	public void setUsuarioDao(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
    

}
