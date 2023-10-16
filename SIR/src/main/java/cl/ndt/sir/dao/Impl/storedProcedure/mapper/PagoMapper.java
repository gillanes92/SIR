package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ndt.sir.model.Pago;


public class PagoMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		Pago rend = new Pago();
		rend.setIdPago(rs.getInt("id"));
		rend.setArchivoOriginal(rs.getString("nombre_archivo_original"));
		rend.setFechaSubida(rs.getString("fecha_subida"));
		rend.setCantidad(rs.getInt("cantidad"));
		rend.setConciliadas(rs.getInt("conciliadas"));
		rend.setEstado(rs.getString("estado_conc"));
		
		return rend;
	}

}
