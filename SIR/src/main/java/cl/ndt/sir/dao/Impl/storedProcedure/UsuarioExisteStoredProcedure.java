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

public class UsuarioExisteStoredProcedure extends StoredProcedure {
	
	private Logger log = (Logger) Logger.getLogger(this.getClass());
	
	private static final String SPROC_NAME = "acspsec.sir_acp_existe_usuario";
	private static final String usuario_in_param	= "id_usuario_in";
	
	private static final String ncod_salida_out_param = "ncod_salida_out";
	private static final String vmsg_salida_out_param = "vmsg_salida_out";
	
	public UsuarioExisteStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
		log.debug("instanciando UsuarioExisteStoredProcedure");
		declareParameter(new SqlParameter(usuario_in_param, Types.VARCHAR));
        
        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
	}
	
	public Map<String, Object> execute(String usuario) throws SQLException {
		Map<String, Object> inputs = new HashMap<String, Object>();
        inputs.put(usuario_in_param, usuario);
       
        Map<String,Object> mapa = super.execute(inputs);
		
		return mapa;

    }

}
