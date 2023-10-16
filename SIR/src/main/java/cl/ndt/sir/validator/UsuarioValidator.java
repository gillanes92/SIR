package cl.ndt.sir.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cl.ndt.sir.form.UsuarioForm;

public class UsuarioValidator implements Validator{
	
	
	public boolean supports(Class arg0) {
		
		return UsuarioForm.class.equals(arg0);
	}


	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
