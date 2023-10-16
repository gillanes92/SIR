package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.ndt.sir.dao.Impl.storedProcedure.mapper.DetallePagoMapper;
import cl.ndt.sir.dao.Impl.storedProcedure.mapper.TarjetaRegistradaMapper;

public class TarjetaRegistradaStoredProcedure extends StoredProcedure{
	
private static final String SPROC_NAME = "oneclick.select_tarjetas_registradas_empresa";
	
	private static final String ID_EMPRESA_IN	= "IN_ID_EMPRESA";
 
	private static final String ncod_salida_out_param	  = "ncod_salida_out";
	private static final String vmsg_salida_out_param	  = "vmsg_salida_out";
	private static final String cur_usuario_out	= "cursor_out";

	public TarjetaRegistradaStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);

		declareParameter(new SqlParameter(ID_EMPRESA_IN, Types.INTEGER));

        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(cur_usuario_out, Types.OTHER, new TarjetaRegistradaMapper()));

        compile();
    }
	
	public Map<String,Object> execute(Integer idEmpresa){
		 
			 Map<String,Object> inParams = new HashMap<String,Object>() ;

			 inParams.put(ID_EMPRESA_IN, idEmpresa);
 
			 return super.execute(inParams);
	}

}
