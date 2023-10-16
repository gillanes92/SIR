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

public class UsuarioInsertHistoricolLoginStoredProcedure extends StoredProcedure{
	
	private Logger log = (Logger) Logger.getLogger(this.getClass());
	
	private static final String SPROC_NAME = "acspsec.sir_acp_ins_historico_login";
	private static final String usuario_in_param	= "usuario_in";
	private static final String accion_in_param	= "accion_in";
	
	private static final String ncod_salida_out_param	= "ncod_salida_out";
	private static final String vmsg_salida_out_param	= "vmsg_salida_out";
	
	public UsuarioInsertHistoricolLoginStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
		log.debug("instanciando UsuarioInsertHistoricolLoginStoredProcedure");
        declareParameter(new SqlParameter(usuario_in_param, Types.INTEGER));
        declareParameter(new SqlParameter(accion_in_param, Types.VARCHAR));
        
        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
        
        compile();
    }
	
	public Map<String, Object> execute(Integer usuario, String accion) throws SQLException {
		log.debug("usuario = ["+usuario+"]");
        Map<String, Object> inputs = new HashMap<String, Object>();
        inputs.put(usuario_in_param, usuario);
        inputs.put(accion_in_param, accion);
       
        Map<String,Object> mapa = super.execute(inputs);
		
		return mapa;

    }

}
