package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.ndt.sir.dao.Impl.storedProcedure.mapper.UsuarioFullMapper;
import cl.ndt.sir.model.Rol;
import cl.ndt.sir.model.Usuario;


public class UsuarioObtenerStoredProcedure extends StoredProcedure {
	private Logger log = (Logger) Logger.getLogger(this.getClass());
	private static final String SPROC_NAME = "acspsec.sir_acp_get_usuario";
	private static final String id_usuario_in_param	= "id_usuario_in";
	private static final String nombre_in_param	= "nombre_in";
	
	private static final String ncod_salida_out_param	= "ncod_salida_out";
	private static final String vmsg_salida_out_param	= "vmsg_salida_out";
	private static final String cur_usuario_out	= "cur_usuario_out";
	
	public UsuarioObtenerStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
		log.debug("instanciando UsuarioObtenerStoredProcedure");
        declareParameter(new SqlParameter(id_usuario_in_param, Types.INTEGER));
        declareParameter(new SqlParameter(nombre_in_param, Types.VARCHAR));
        
        declareParameter(new SqlOutParameter(ncod_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(vmsg_salida_out_param, Types.VARCHAR));
        declareParameter(new SqlOutParameter(cur_usuario_out, Types.OTHER, new UsuarioFullMapper() ));
        
        compile();
    }
	
	public Map<String, Object> execute(Integer id_usuario, String usuario) throws SQLException {
		log.debug("id_usuario = ["+id_usuario+"]");
		log.debug("usuario = ["+usuario+"]");
        Map<String, Object> inputs = new HashMap<String, Object>();
        inputs.put(id_usuario_in_param, id_usuario);
        inputs.put(nombre_in_param, usuario);
       
        Map<String,Object> mapa = super.execute(inputs);

		if(mapa.get(cur_usuario_out)!=null){
			mapa.put("usuario",armarUsuario((List<Usuario>)mapa.get(cur_usuario_out)));
		}
		
		return mapa;

    }
	
	
	private Usuario armarUsuario(List<Usuario> usuarios){
		Usuario usuario = new Usuario();
 
		usuario = usuarios.get(0);
		List<Rol> roles = new ArrayList<Rol>();
		for(Usuario u : usuarios){
			roles.add(u.getRolActual());
		}
		usuario.setRoles(roles);
		return usuario;
	}
	
	
}
