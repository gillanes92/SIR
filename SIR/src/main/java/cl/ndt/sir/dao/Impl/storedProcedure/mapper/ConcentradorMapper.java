package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ndt.sir.model.Concentrador;

public class ConcentradorMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		Concentrador datos = new Concentrador();
		datos.setIdConcentrador(rs.getInt("id_concentrador"));
		datos.setNomConcentrador(rs.getString("nom_concentrador"));
		
		return datos;
	}
}
