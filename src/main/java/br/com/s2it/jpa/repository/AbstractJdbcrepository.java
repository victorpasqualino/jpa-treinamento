package br.com.s2it.jpa.repository;

import java.sql.Connection;

public abstract class AbstractJdbcrepository<I, T> implements JdbcRepository<I, T> {
	
	private Connection connection;
	
	public AbstractJdbcrepository(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Connection getConnection() {
		return connection;
	}

}
