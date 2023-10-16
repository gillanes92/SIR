package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ndt.sir.model.Rendicion;


public class RendicionMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		Rendicion rend = new Rendicion();
		rend.setIdRendicion(rs.getInt("id_rend"));
		rend.setCodigoComercio(rs.getString("codigo_comercio"));
		rend.setNombreFantasia(rs.getString("nombre_fantasia"));
		rend.setProducto(rs.getString("producto"));
		rend.setFechaAbono(rs.getString("fecha_abono"));
		rend.setFechaRendicion(rs.getString("fecha_rend"));
		rend.setCantidad(rs.getInt("cantidad"));
		rend.setConciliadas(rs.getInt("conciliadas"));
		rend.setEstado(rs.getString("estado"));
		rend.setImage(rs.getString("image"));
		
		return rend;
	}

}
