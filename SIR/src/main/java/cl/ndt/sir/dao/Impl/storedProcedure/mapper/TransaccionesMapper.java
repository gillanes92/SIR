package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.ndt.sir.model.Transaccion;

public class TransaccionesMapper implements  RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		Transaccion datos = new Transaccion();
		datos.setEmpresa(rs.getString("nombre_empresa"));
		datos.setIdentificador(rs.getString("identificador"));
		datos.setAmount(rs.getString("amount"));
		datos.setTransactionOrder(rs.getString("transaction_order"));
		datos.setTransactionType(rs.getString("transaction_type"));
		datos.setEstado(rs.getString("estado"));
		datos.setCardNumber(rs.getString("card_number"));
		datos.setFechRegistro(rs.getString("fecha_registro"));
		datos.setDetalleBuyOrder(rs.getString("detalle_buy_order"));
		datos.setDetalleCommerceCode(rs.getString("detalle_commerce_code"));
		datos.setDetallePaymentTypeCode(rs.getString("detalle_payment_type_code"));
		datos.setFechaPago(rs.getString("fecha_pago"));
		
		
		return datos;
	}

}
