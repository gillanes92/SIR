package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.ndt.sir.dao.Impl.storedProcedure.mapper.DatosFtpMapper;

public class ObtieneDatosFtpStoredProcedure extends StoredProcedure{
	
	private static final String SPROC_NAME = "REPCONC.SIR_REP_DATOSFTP_SEL";
	
	private static final String V_ID_EMPRESA_IN	= "IN_ID_EMPRESA";
	private static final String V_IN_TIPO_PROCESO	= "IN_TIPO_PROCESO";
 
	private static final String ncod_salida_out_param	  = "ncod_salida_out";
	private static final String vmsg_salida_out_param	  = "vmsg_salida_out";
	private static final String cur_ftp = "cur_ftp";

	public ObtieneDatosFtpStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);

		declareParameter(new SqlParameter(V_ID_EMPRESA_IN, Types.INTEGER));
		declareParameter(new SqlParameter(V_IN_TIPO_PROCESO, Types.VARCHAR));

        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(cur_ftp, Types.OTHER, new DatosFtpMapper()));

        compile();
    }
	
	public Map<String,Object> execute(Integer idEmpresa, String tipoProceso){
		 
			 Map<String,Object> inParams = new HashMap<String,Object>() ;

			 inParams.put(V_ID_EMPRESA_IN, idEmpresa);
			 inParams.put(V_IN_TIPO_PROCESO, tipoProceso);
 
			 return super.execute(inParams);
	}

}
