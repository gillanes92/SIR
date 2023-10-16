package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ndt.sir.model.DetallePago;

public class DetallePagoMapper implements  RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		DetallePago datos = new DetallePago();
		datos.setIdDetallePago(rs.getInt("id"));
		datos.setIdentificador(rs.getString("identificador"));
		datos.setMontoPago(rs.getString("monto_pago"));
		datos.setTipoTarjeta(rs.getString("tipo_tarjeta"));
		datos.setCodAutorizacion(rs.getString("cod_autorizacion"));
		datos.setFechaVenta(rs.getString("fecha_venta"));
		datos.setEstadoConcilia(rs.getString("est_conc"));
		datos.setIdRend(rs.getInt("id_rend"));
		
		return datos;
	}

}
