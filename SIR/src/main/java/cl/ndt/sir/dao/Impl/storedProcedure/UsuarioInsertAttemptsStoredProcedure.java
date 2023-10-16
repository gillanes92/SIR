package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.ndt.sir.dao.Impl.storedProcedure.mapper.UserAttemptsMapper;

public class UsuarioInsertAttemptsStoredProcedure extends StoredProcedure{
	
	private Logger log = (Logger) Logger.getLogger(this.getClass());
	
	private static final String SPROC_NAME = "acspsec.sir_acp_ins_attempts_usuario";
	private static final String usuario_in_param	= "usuario_in";
	private static final String attempts_in_param	= "attempts_in";
	
	private static final String ncod_salida_out_param	= "ncod_salida_out";
	private static final String vmsg_salida_out_param	= "vmsg_salida_out";
	
	public UsuarioInsertAttemptsStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
		log.debug("instanciando UsuarioInsertAttemptsStoredProcedure");
        declareParameter(new SqlParameter(usuario_in_param, Types.VARCHAR));
        declareParameter(new SqlParameter(attempts_in_param, Types.VARCHAR));
        
        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
        
        compile();
    }
	
	public Map<String, Object> execute(String usuario, Integer attempts) throws SQLException {
		log.debug("usuario = ["+usuario+"]");
        Map<String, Object> inputs = new HashMap<String, Object>();
        inputs.put(usuario_in_param, usuario);
        inputs.put(attempts_in_param, attempts.toString());
       
        Map<String,Object> mapa = super.execute(inputs);
		
		return mapa;

    }

}
