package cl.ndt.sir.dao.Impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.LockedException;

import cl.ndt.sir.dao.UserDetailsDao;
import cl.ndt.sir.dao.Impl.storedProcedure.UsuarioExisteStoredProcedure;
import cl.ndt.sir.dao.Impl.storedProcedure.UsuarioGetAttemptsStoredProcedure;
import cl.ndt.sir.dao.Impl.storedProcedure.UsuarioInsertAttemptsStoredProcedure;
import cl.ndt.sir.dao.Impl.storedProcedure.UsuarioUpdateLockedStoredProcedure;
import cl.ndt.sir.model.UserAttempts;
import cl.ndt.sir.utils.MyDelegatingDS;

import javax.annotation.PostConstruct;

public class UserDetailsDaoImpl implements UserDetailsDao {
	private Logger log = (Logger) Logger.getLogger(this.getClass());

	//private static final String SQL_USERS_UPDATE_LOCKED = "UPDATE acspsec.ACC_USUARIO SET \"accountNonLocked\" = ? WHERE usuario = ?";
	//private static final String SQL_USERS_UPDATE_CREDENTIALS_EXPIRED = "UPDATE acspsec.ACC_USUARIO SET \"credentialsNonExpired\" = ? WHERE usuario = ?";
	//private static final String SQL_USERS_COUNT = "SELECT count(*) FROM acspsec.ACC_USUARIO u WHERE u.usuario = ?";
	
	//private static final String SQL_USER_ATTEMPTS_GET = "SELECT * FROM acspsec.USER_ATTEMPTS WHERE username = ? order by id desc limit 1";
	//private static final String SQL_USER_ATTEMPTS_INSERT = "INSERT INTO acspsec.USER_ATTEMPTS (USERNAME, ATTEMPTS, LASTMODIFIED) VALUES(?,?,?)";
	//private static final String SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS = "UPDATE acspsec.USER_ATTEMPTS SET attempts = cast(attempts as integer) + 1, lastmodified = ? WHERE username = ?";
	//private static final String SQL_USER_ATTEMPTS_RESET_ATTEMPTS = "UPDATE acspsec.USER_ATTEMPTS SET attempts = 0, lastmodified = null WHERE username = ?";

	
	private static final int MAX_ATTEMPTS = 3;

	private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
 
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	public void updateFailAttempts(String username) throws SQLException {

	  UserAttempts user = getUserAttempts(username);
	  
	  MyDelegatingDS mds = new MyDelegatingDS(true, this.dataSource);
	  UsuarioInsertAttemptsStoredProcedure userInsAttemSP = new UsuarioInsertAttemptsStoredProcedure(mds);
	  
	  if (user == null) {
		if (isUserExists(username)) {
			// if no record, insert a new
			Map<String,Object> mapa = userInsAttemSP.execute(username, 1);
			log.info("Intento Fallido iniciar sesión usuario: "+ username);
		}
	  } else {

		if (isUserExists(username) && user.getAttempts() > 0) {
			// update attempts count, +1
			Map<String,Object> mapa = userInsAttemSP.execute(username, user.getAttempts() + 1);
			//getJdbcTemplate().update(SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS, new Object[] { new Date(), username});
			
		}else {
			Map<String,Object> mapa = userInsAttemSP.execute(username, 1);
		}

		if (user.getAttempts() + 1 >= MAX_ATTEMPTS) {
			// locked user
			MyDelegatingDS ds = new MyDelegatingDS(true, this.dataSource);
			UsuarioUpdateLockedStoredProcedure sp = new UsuarioUpdateLockedStoredProcedure(ds);
			Map<String,Object> mapa = sp.execute(username, 0);
			// throw exception
			throw new LockedException("User Account is locked!");
		}
		
		log.info("Intento Fallido iniciar sesión usuario: "+ username);

	  }

	}

	public void resetFailAttempts(String username) throws SQLException {
		MyDelegatingDS ds = new MyDelegatingDS(true, this.dataSource);
		UsuarioInsertAttemptsStoredProcedure userInsAttemSP = new UsuarioInsertAttemptsStoredProcedure(ds);
		Map<String,Object> mapa = userInsAttemSP.execute(username, 0);	  
	}
	
	public UserAttempts getUserAttempts(String username) {

		try {
			MyDelegatingDS ds = new MyDelegatingDS(false, this.dataSource);
			UsuarioGetAttemptsStoredProcedure sp = new UsuarioGetAttemptsStoredProcedure(ds);
			UserAttempts userAttempts = sp.executar(username);
			
			return userAttempts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}
	
	private boolean isUserExists(String username) throws SQLException {

	  boolean result = false;
	  MyDelegatingDS ds = new MyDelegatingDS(false, this.dataSource);
	  UsuarioExisteStoredProcedure sp = new UsuarioExisteStoredProcedure(ds);
	  Map<String,Object> mapa = sp.execute(username);
	  Integer count = Integer.valueOf(mapa.get("vmsg_salida_out").toString()); 
	  if (count > 0) {
		result = true;
	  }

	  return result;
	}
		

}