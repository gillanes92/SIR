package cl.ndt.sir.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import cl.ndt.sir.dao.UserDetailsDao;
import cl.ndt.sir.model.UserAttempts;


@Component("authenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {

	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Autowired
	@Qualifier("userDetailsService")
	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		super.setUserDetailsService(userDetailsService);
	}
	
	@Autowired
	@Qualifier("passwordEncoder")
	@Override
	public void setPasswordEncoder(Object passwordEncoder) {
		Md5PasswordEncoder a;
		super.setPasswordEncoder(passwordEncoder);
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) 
          throws AuthenticationException {

		try {

			Authentication auth = super.authenticate(authentication);
			
			try {
				userDetailsDao.resetFailAttempts(authentication.getName());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return auth;
			
		}catch (BadCredentialsException e) {	
			
			try {
				userDetailsDao.updateFailAttempts(authentication.getName());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
			
		}catch (LockedException e){
			
		//this user is locked!
			String error = "";
			UserAttempts userAttempts = userDetailsDao.getUserAttempts(authentication.getName());
		
			if(userAttempts!=null){
				Date lastAttempts = userAttempts.getLastModified();
				error =  " <br><br>Username : "  + authentication.getName() + "<br>Ultimo intento : " + lastAttempts;
			}else{
				error = authentication.getName();
			}
			
			throw new LockedException(error);
		}

	}

	public void setUserDetailsDao(UserDetailsDao userDetailsDao) {
		this.userDetailsDao = userDetailsDao;
	}

	
	
	
	
	
}
