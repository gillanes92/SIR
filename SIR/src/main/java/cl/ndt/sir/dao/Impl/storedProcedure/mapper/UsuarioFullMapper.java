package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import cl.ndt.sir.model.Empresa;
import cl.ndt.sir.model.Rol;
import cl.ndt.sir.model.Usuario;

public class UsuarioFullMapper implements  RowMapper{
	private Logger log = (Logger) Logger.getLogger(this.getClass());
		
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		log.debug("mapeando fila = ["+rowNum+"] en UsuarioMapper");
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("ID_USUARIO"));
		usuario.setUsuario(rs.getString("USUARIO"));
		usuario.setNombre(rs.getString("NOMBRE"));
		usuario.setPassword(rs.getString("PASSWORD"));
		usuario.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
		usuario.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
		usuario.setCorreo(rs.getString("CORREO"));
		usuario.setTelefono(rs.getString("TELEFONO"));
		usuario.setSuperUsuario(rs.getBoolean("SUPERUSUARIO"));
		usuario.setEstado(rs.getBoolean("ESTADO"));
		usuario.setFechaActualizacion(rs.getDate("FECHA_ACTUALIZACION"));
		usuario.setFechaActualizacionPassword(rs.getDate("FECHA_ACTUALIZACION_PASSWORD"));
		Empresa empresa = new Empresa();
		empresa.setId(rs.getInt("ID_EMPRESA"));
		empresa.setNombre(rs.getString("NOMBRE_EMPRESA"));
		usuario.setEmpresa(empresa);
		
		Rol rol = new Rol();
		rol.setId(rs.getInt("ID_ROL"));
		rol.setNombre(rs.getString("NOMBRE_ROL"));
		rol.setEmpresa(empresa);
		usuario.setRolActual(rol);
		
		return usuario;
	}
}
