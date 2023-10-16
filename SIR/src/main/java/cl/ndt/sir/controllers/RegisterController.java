package cl.ndt.sir.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cl.ndt.sir.dao.UsuarioManager;

public class RegisterController implements Controller {
	
protected final Log log = LogFactory.getLog(getClass());
    
 	private UsuarioManager usuarioManager;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		HttpSession session = request.getSession();
		
    	log.info("INICIANDO RegisterController");
		

		ModelAndView model = new ModelAndView();

		model.setViewName("/pages/register");

        return model;
    }
    
    public void setUsuarioManager(UsuarioManager usuarioManager){
		this.usuarioManager = usuarioManager;
    }

}
