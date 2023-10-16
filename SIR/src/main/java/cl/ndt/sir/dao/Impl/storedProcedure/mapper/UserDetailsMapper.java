package cl.ndt.sir.dao.Impl.storedProcedure.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class UserDetailsMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		String username = rs.getString("username");
		String password = rs.getString("password");
		boolean enabled = rs.getBoolean("enabled");
		boolean accountNonExpired = rs.getBoolean("accountNonExpired");
		boolean credentialsNonExpired = rs.getBoolean("credentialsNonExpired");
		boolean accountNonLocked = rs.getBoolean("accountNonLocked");

		return new User(username, password, enabled, accountNonExpired, credentialsNonExpired,
			accountNonLocked, AuthorityUtils.NO_AUTHORITIES);
	}

}
