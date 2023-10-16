package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import cl.ndt.sir.model.UserAttempts;

public class UserAttemptsMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserAttempts user = new UserAttempts();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setAttempts(rs.getInt("attempts"));
		user.setLastModified(rs.getDate("lastModified"));

		return user;	}

}
