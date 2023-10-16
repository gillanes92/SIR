package cl.ndt.sir.controllers;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cl.ndt.sir.dao.UsuarioDao;
import cl.ndt.sir.dao.UsuarioManager;


public class LoginController implements Controller {

	protected final Log log = LogFactory.getLog(getClass());
    

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	log.info("INICIANDO LoginController");
    	if(SecurityContextHolder.getContext().getAuthentication() != null){
			
			String nombreUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
 
			log.info("username=["+nombreUsuario+"]");			

			if(nombreUsuario.trim() != null &&
			   nombreUsuario.trim() != ""   && 
			   nombreUsuario.compareTo("anonymousUser")!=0){				
							        
				response.sendRedirect("home.htm");
			
			}
		}
		

		ModelAndView model = new ModelAndView();
		
		model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));

		model.setViewName("/pages/login");

        return model;
    }
    
    private String getErrorMessage(HttpServletRequest request, String key){
      	
  		Exception exception = (Exception) request.getSession().getAttribute(key);
	   		
  		String error = "";
  		if (exception instanceof BadCredentialsException) {
  			error = "Credenciales invalidas!";
  		}else if(exception instanceof LockedException) {
  			error = "Cuenta bloqueada!";
  		}else if (exception instanceof CredentialsExpiredException){
  			error = "La contraseña a cadudado!";
  		}else {
  			error = "";
  		}
  		
  		return error;
  	}
    
}
