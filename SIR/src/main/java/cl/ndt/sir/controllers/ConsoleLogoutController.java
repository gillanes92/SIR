package cl.ndt.sir.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import cl.ndt.sir.dao.Impl.storedProcedure.UsuarioInsertHistoricolLoginStoredProcedure;
import cl.ndt.sir.dao.Impl.storedProcedure.UsuarioObtenerStoredProcedure;
import cl.ndt.sir.model.Usuario;
import cl.ndt.sir.utils.MyDelegatingDS;

@Component
public class ConsoleLogoutController extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Map<String, Object> obtenerUsuarioPorNombre(String nombre) {

		MyDelegatingDS ds = new MyDelegatingDS(false, this.dataSource);

		UsuarioObtenerStoredProcedure usuarioObtener = new UsuarioObtenerStoredProcedure(ds);

		try {
			return usuarioObtener.execute(null, nombre);
		} catch (Exception e) {
			return new HashMap<String, Object>();
		}
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		Usuario usuario = null;
		Map<String, Object> usuarios = obtenerUsuarioPorNombre(authentication.getName());

		usuario = (Usuario) usuarios.get("usuario");

		UsuarioInsertHistoricolLoginStoredProcedure sp = new UsuarioInsertHistoricolLoginStoredProcedure(
				this.dataSource);
		try {
			sp.execute(usuario.getId(), "Logout");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		@SuppressWarnings("unused")
		String refererUrl = request.getHeader("Referer");

		super.onLogoutSuccess(request, response, authentication);
	}
}
