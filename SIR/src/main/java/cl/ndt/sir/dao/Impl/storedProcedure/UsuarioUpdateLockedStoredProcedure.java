package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class UsuarioUpdateLockedStoredProcedure extends StoredProcedure {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private static final String SPROC_NAME = "acspsec.sir_acp_upd_locked_usuario";
	private static final String usuario_in_param	= "usuario_in";
	private static final String accountnonlocked_in_param	= "accountnonlocked_in";
	
	private static final String ncod_salida_out_param = "ncod_salida_out";
	private static final String vmsg_salida_out_param = "vmsg_salida_out";
	
	
	public UsuarioUpdateLockedStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
		log.debug("instanciando UsuarioUpdateLockedStoredProcedure");
		declareParameter(new SqlParameter(usuario_in_param, Types.VARCHAR));
        declareParameter(new SqlParameter(accountnonlocked_in_param, Types.INTEGER));
        
        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
	}
	
	public Map<String, Object> execute(String usuario, Integer accountnonlocked) throws SQLException {
		Map<String, Object> inputs = new HashMap<String, Object>();
        inputs.put(usuario_in_param, usuario);
        inputs.put(accountnonlocked_in_param, accountnonlocked);
       
        Map<String,Object> mapa = super.execute(inputs);
		
		return mapa;

    }

}
