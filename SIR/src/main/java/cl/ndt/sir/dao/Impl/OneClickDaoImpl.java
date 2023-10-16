package cl.ndt.sir.dao.Impl;

import java.util.Map;

import javax.sql.DataSource;

import cl.ndt.sir.dao.OneClickDao;
import cl.ndt.sir.dao.RendicionesDao;
import cl.ndt.sir.dao.Impl.storedProcedure.PagoInsertStoredProcedure;
import cl.ndt.sir.utils.MyDelegatingDS;

public class OneClickDaoImpl implements OneClickDao {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public Map<String, Object> cargarPagoMasivoOC(String date, String nombreArchivo, Integer idUsuario, Integer idEmpresa) {
		// TODO Auto-generated method stub
		MyDelegatingDS ds = new MyDelegatingDS(true, this.dataSource);
		PagoInsertStoredProcedure sp = new PagoInsertStoredProcedure(ds);
		return sp.execute(date, nombreArchivo, idUsuario, idEmpresa, "");
	}
}
