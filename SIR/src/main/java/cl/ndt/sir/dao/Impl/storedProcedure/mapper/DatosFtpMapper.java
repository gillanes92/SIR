package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ndt.sir.model.DatosFtp;

public class DatosFtpMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		DatosFtp datos = new DatosFtp();
		datos.setServer(rs.getString("SERVER"));
		datos.setUsuario(rs.getString("USUARIO"));
		datos.setClave(rs.getString("CLAVE"));
		datos.setPuerto(rs.getInt("PUERTO"));
		datos.setRuta(rs.getString("RUTA"));
		datos.setAmbiente(rs.getString("AMBIENTE"));
		
		return datos;
	}
	
	

}
