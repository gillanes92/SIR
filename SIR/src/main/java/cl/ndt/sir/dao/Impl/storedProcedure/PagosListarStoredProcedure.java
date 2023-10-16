package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.ndt.sir.dao.Impl.storedProcedure.mapper.PagoMapper;

public class PagosListarStoredProcedure extends StoredProcedure{
	
	private static final String SPROC_NAME = "trxconc.sir_listado_pagos";

	private static final String ID_EMPRESA_IN = "IN_ID_EMPRESA";

	private static final String ncod_salida_out_param	= "ncod_salida_out";
	private static final String vmsg_salida_out_param	= "vmsg_salida_out";
	private static final String cur_usuario_out	= "cur_usuario_out";
	
	public PagosListarStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
        declareParameter(new SqlParameter(ID_EMPRESA_IN, Types.INTEGER));
        
        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(cur_usuario_out, Types.OTHER, new PagoMapper() ));
        
        compile();
    }
	
	public Map<String, Object> execute(Integer id_empresa) throws SQLException {
		
        Map<String, Object> inputs = new HashMap<String, Object>();
        inputs.put(ID_EMPRESA_IN, id_empresa);
       
        Map<String,Object> mapa = super.execute(inputs);

		
		return mapa;

    }

}
