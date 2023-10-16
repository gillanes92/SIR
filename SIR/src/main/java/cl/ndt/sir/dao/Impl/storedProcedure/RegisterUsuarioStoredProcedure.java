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

public class RegisterUsuarioStoredProcedure extends StoredProcedure{

private Logger log = (Logger) Logger.getLogger(this.getClass());
	
	private static final String SPROC_NAME = "acspsec.sir_acp_registrar_usuario";
	private static final String nombre_in_param	= "nombre_in";
	private static final String password_in_param	= "password_in";
	private static final String correo_in_param	= "correo_in";
	private static final String id_empresa_in_param	= "id_empresa_in";
	
	private static final String ncod_salida_out_param	= "ncod_salida_out";
	private static final String vmsg_salida_out_param	= "vmsg_salida_out";
	
	public RegisterUsuarioStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
		log.debug("instanciando RegisterUsuarioStoredProcedure");
        declareParameter(new SqlParameter(nombre_in_param, Types.VARCHAR));
        declareParameter(new SqlParameter(password_in_param, Types.VARCHAR));
        declareParameter(new SqlParameter(correo_in_param, Types.VARCHAR));
        declareParameter(new SqlParameter(id_empresa_in_param, Types.INTEGER));
        
        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
        
        compile();
    }
	
	public Map<String, Object> execute(String nombre, String password, String correo, Integer id_empresa) throws SQLException {
        Map<String, Object> inputs = new HashMap<String, Object>();
        inputs.put(nombre_in_param, nombre);
        inputs.put(password_in_param, password);
        inputs.put(correo_in_param, correo);
        inputs.put(id_empresa_in_param, id_empresa);
       
        Map<String,Object> mapa = super.execute(inputs);
		
		return mapa;

    }
}
