package cl.ndt.sir.dao;

import java.sql.SQLException;

import cl.ndt.sir.model.UserAttempts;

public interface UserDetailsDao {
	
	
	void updateFailAttempts(String username) throws SQLException;
	void resetFailAttempts(String username) throws SQLException;
	UserAttempts getUserAttempts(String username);

}
