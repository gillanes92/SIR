package cl.ndt.sir.dao;

import java.util.Map;

public interface OneClickDao {

	public Map<String, Object> cargarPagoMasivoOC(String date, String nombreArchivo, Integer idUsuario, Integer idEmpresa);
}
