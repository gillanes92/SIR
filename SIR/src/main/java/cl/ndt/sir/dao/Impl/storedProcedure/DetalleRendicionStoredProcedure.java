package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.ndt.sir.dao.Impl.storedProcedure.mapper.DetalleRendMapper;

public class DetalleRendicionStoredProcedure extends StoredProcedure{
	
private static final String SPROC_NAME = "repconc.sir_get_detalle_rendicion";
	
	private static final String ID_RENDICION_IN	= "IN_ID_REND";
 
	private static final String ncod_salida_out_param	  = "ncod_salida_out";
	private static final String vmsg_salida_out_param	  = "vmsg_salida_out";
	private static final String cur_usuario_out	= "cur_det_rend_out";

	public DetalleRendicionStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);

		declareParameter(new SqlParameter(ID_RENDICION_IN, Types.INTEGER));

        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(cur_usuario_out, Types.OTHER, new DetalleRendMapper()));

        compile();
    }
	
	public Map<String,Object> execute(Integer idRend){
		 
			 Map<String,Object> inParams = new HashMap<String,Object>() ;

			 inParams.put(ID_RENDICION_IN, idRend);
 
			 return super.execute(inParams);
	}

}
