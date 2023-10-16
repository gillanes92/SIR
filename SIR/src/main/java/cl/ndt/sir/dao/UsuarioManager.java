package cl.ndt.sir.dao;

import cl.ndt.sir.model.Rol;
import cl.ndt.sir.model.Usuario;

public interface UsuarioManager {

	public Usuario obtenerUsuarioLogueado();
	public Rol obtenerRolDeUsuarioLogueado();
}
