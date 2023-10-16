package cl.ndt.sir.dao.Impl.storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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

import cl.ndt.sir.model.UserAttempts;


public class UsuarioGetAttemptsStoredProcedure extends StoredProcedure{
	
	private Logger log = (Logger) Logger.getLogger(this.getClass());
	
	private static final String SPROC_NAME = "acspsec.sir_acp_get_attempts_usuario";
	private static final String usuario_in_param	= "usuario_in";
		
	Connection connection;
	
	public UsuarioGetAttemptsStoredProcedure(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
		log.debug("instanciando UsuarioGetAttemptsStoredProcedure");
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public UserAttempts executar(String usuario) throws SQLException {
		UserAttempts userAttempts = new UserAttempts();
		CallableStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection.setAutoCommit(false);

			stmt = connection.prepareCall("{call acspsec.sir_acp_get_attempts_usuario(?)}");
			stmt.setString(1, usuario);

			stmt.execute();
						
			rs = stmt.getResultSet();

			while (rs.next()) {
				
				ResultSet rs2 = (ResultSet) rs.getObject(3);
				
				if (rs.getString(1).equals("000")){
					while (rs2.next()) {
					
						userAttempts.setId(rs2.getInt(1));
						userAttempts.setUsername(rs2.getString(2));
						userAttempts.setAttempts(rs2.getInt(3));
						userAttempts.setLastModified(rs2.getDate(4));
					}
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			connection.close();
		}	
		return userAttempts;
	}

}
