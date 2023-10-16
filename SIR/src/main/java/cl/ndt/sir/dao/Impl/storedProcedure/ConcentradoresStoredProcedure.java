package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.ndt.sir.dao.Impl.storedProcedure.mapper.ConcentradorMapper;

public class ConcentradoresStoredProcedure extends StoredProcedure{

private static final String SPROC_NAME = "trxconc.sir_get_concentradores";
	 
	private static final String ncod_salida_out_param	  = "ncod_salida_out";
	private static final String vmsg_salida_out_param	  = "vmsg_salida_out";
	private static final String cur_cons = "cur_con";

	public ConcentradoresStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);

        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(cur_cons, Types.OTHER, new ConcentradorMapper()));

        compile();
    }
	
	public Map<String,Object> execute(){
		 
			 Map<String,Object> inParams = new HashMap<String,Object>() ;
 
			 return super.execute(inParams);
	}
}
