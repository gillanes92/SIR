package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ndt.sir.model.TarjetaRegistrada;

public class TarjetaRegistradaMapper implements  RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		TarjetaRegistrada datos = new TarjetaRegistrada();
		datos.setEmpresa(rs.getString("nombre"));
		datos.setIdentificador(rs.getString("identificador"));
		datos.setCorreo(rs.getString("correo"));
		datos.setCardNumber(rs.getString("card_number"));
		datos.setCardType(rs.getString("card_type"));
		datos.setFechaCreacion(rs.getString("fecha_creacion"));
		
		return datos;
	}

}
