package cl.ndt.sir.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Service;

import cl.ndt.sir.dao.Impl.storedProcedure.mapper.UserDetailsMapper;


@Service("userDetailsService")
public class CustomUserDetailsService extends JdbcDaoImpl {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	@Value("SELECT"+
                "  u.USUARIO AS username,"+
                "  u.password,"+
                "  u.estado AS enabled,"+
                "  u.\"accountNonExpired\" AS accountNonExpired,"+
                "  u.\"accountNonLocked\" AS accountNonLocked,"+
                "  u.\"credentialsNonExpired\" AS credentialsNonExpired "+
                "FROM"+
                "    acspsec.ACC_USUARIO u"+
                "WHERE"+
                "     u.USUARIO =  ?")
	public void setUsersByUsernameQuery(String usersByUsernameQueryString) {
		super.setUsersByUsernameQuery(usersByUsernameQueryString);
	}
	
	@Override
	@Value("SELECT u.USUARIO AS username,"+
     		" p.codigo AS authority"+
            "FROM"+
            "    acspsec.ACC_USUARIO u"+
            "        inner join acspsec.ACC_USUARIO_EMPRESA_ROL aer"+
            "            on aer.id_usuario = u.id_usuario and aer.id_empresa = u.id_empresa"+
            "        inner join acspsec.ACC_ROL r"+
            "            on aer.id_rol = r.id_rol"+
            "        inner join acspsec.ACC_ROL_PERMISO rp"+
            "            on rp.id_rol = r.id_rol"+
            "        inner join acspsec.ACC_PERMISO p"+
            "             on p.id_permiso = rp.id_permiso"+
		"WHERE"+
	      "    u.USUARIO = ?")
	public void setAuthoritiesByUsernameQuery(String queryString) {
		super.setAuthoritiesByUsernameQuery(queryString);
	}

	//override to get accountNonLocked  
	@Override
	public List<UserDetails> loadUsersByUsername(String username) {
	  return getJdbcTemplate().query(super.getUsersByUsernameQuery(), new String[] { username },
		new UserDetailsMapper());
	}

	//override to pass accountNonLocked
	@Override
	public UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
			List<GrantedAuthority> combinedAuthorities) {
		String returnUsername = userFromUserQuery.getUsername();

		if (super.isUsernameBasedPrimaryKey()) {
		  returnUsername = username;
		}

		return new User(returnUsername, userFromUserQuery.getPassword(), 
                       userFromUserQuery.isEnabled(),
		       userFromUserQuery.isAccountNonExpired(), 
                       userFromUserQuery.isCredentialsNonExpired(),
			userFromUserQuery.isAccountNonLocked(), combinedAuthorities);
	}

}