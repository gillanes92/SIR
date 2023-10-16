package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ndt.sir.model.DetalleRend;


public class DetalleRendMapper implements  RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		DetalleRend datos = new DetalleRend();
		datos.setIdDetalleRend(rs.getInt("id_detalle_rend"));
		datos.setTipoTrans(rs.getString("tipo_transaccion"));
		datos.setFecVenta(rs.getString("fecha_venta"));
		datos.setTipoTarjeta(rs.getString("tipo_tarjeta"));
		datos.setIdentificador(rs.getString("identificador"));
		datos.setCodAutorizacion(rs.getString("codigo_autorizacion"));
		datos.setMonto(rs.getString("monto_transaccion"));
		datos.setMontoAnulacion(rs.getString("monto_anulacion"));
		datos.setEstadoConcilia(rs.getString("estado_concilia"));
		datos.setIdPago(rs.getInt("id_pago"));
		
		return datos;
	}
}
