package cl.ndt.sir.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DelegatingDataSource;

public class MyDelegatingDS extends DelegatingDataSource{
	
	private final boolean autoCommit;
	
	public MyDelegatingDS(final boolean autoCommit, final DataSource dataSource) {
	    super(dataSource);
	    this.autoCommit = autoCommit;
	}
	
	@Override
    public Connection getConnection() throws SQLException {
		final Connection cnx = super.getConnection();
		cnx.setAutoCommit(this.autoCommit);
		return cnx;
	}

}
