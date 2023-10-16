package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class PagoInsertStoredProcedure extends StoredProcedure {
	private static final String SPROC_NAME = "trxconc.sir_ins_pagos";

	private static final String FECHA_IN = "IN_FEC_REND";
	private static final String NOM_ARCHIVO = "IN_NOM_ARCHIVO";
	private static final String ID_USUARIO = "IN_ID_USUARIO";
	private static final String ID_EMPRESA_IN = "IN_ID_EMPRESA";
	private static final String ID_CONC_IN = "IN_ID_CONC";

	private static final String resultado_out = "RESULTADO_OUT";

	private static final String ncod_salida_out = "NCOD_SALIDA_OUT";
	private static final String vmsg_salida_out = "VMSG_SALIDA_OUT";

	private Logger log = (Logger) Logger.getLogger(this.getClass());

	public PagoInsertStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);

		declareParameter(new SqlParameter(FECHA_IN, Types.VARCHAR));
		declareParameter(new SqlParameter(NOM_ARCHIVO, Types.VARCHAR));
		declareParameter(new SqlParameter(ID_USUARIO, Types.INTEGER));
		declareParameter(new SqlParameter(ID_EMPRESA_IN, Types.INTEGER));
		declareParameter(new SqlParameter(ID_CONC_IN, Types.INTEGER));

		declareParameter(new SqlOutParameter(resultado_out, Types.VARCHAR));
		declareParameter(new SqlOutParameter(ncod_salida_out, Types.VARCHAR));
		declareParameter(new SqlOutParameter(vmsg_salida_out, Types.VARCHAR));

		compile();
	}

	public Map<String, Object> execute(String date, String nombreArchivo, Integer idUsuario,
			Integer idEmpresa, String idConc) {

		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put(FECHA_IN, date);
		inParams.put(NOM_ARCHIVO, nombreArchivo);
		inParams.put(ID_USUARIO, idUsuario);
		inParams.put(ID_EMPRESA_IN, idEmpresa);
		inParams.put(ID_CONC_IN, Integer.valueOf(idConc));

		log.debug("inParams = [" + inParams.toString() + "]");

		Map<String, Object> outParams = super.execute(inParams);

		log.debug("outParams = [" + outParams.toString() + "]");

		return outParams;
	}

}
