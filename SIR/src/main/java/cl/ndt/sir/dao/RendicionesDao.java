package cl.ndt.sir.dao;

import java.sql.SQLException;
import java.util.Map;

import cl.ndt.sir.model.DatosFtp;

public interface RendicionesDao {

	public Map<String, Object> cargarRendiciones(String date, String nombreArchivo, Integer idUsuario,
			Integer idEmpresa, String razonSocial, String codigoComercio, String nombreFantasia, String producto,
			String fechaAbono, String abonoCalculado, String idCon);

	public DatosFtp obtenerDatosFtp(Integer idEmpresa, String tipoProceso);

	public Map<String, Object> listarRendiciones(Integer id_empresa) throws SQLException;
	
	public Map<String, Object> obtenerDetallesRend(Integer idRend);

	public Map<String, Object> concentradores();

	public Map<String, Object> cargarPago(String date, String nombreArchivo, Integer idUsuario, Integer idEmpresa, String codConc);

	public Map<String, Object> listarPagos(Integer id);

	public Map<String, Object> obtenerDetallesPago(Integer id);
	
	public Map<String, Object> tarjetasRegistradas(Integer id);
	
	public Map<String, Object> obtenerTransacciones(Integer id);

}
