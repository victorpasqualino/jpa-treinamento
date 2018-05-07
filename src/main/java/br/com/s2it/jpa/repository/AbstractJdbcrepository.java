package br.com.s2it.jpa.repository;

import javax.sql.DataSource;

public abstract class AbstractJdbcrepository<I, T> implements JdbcRepository<I, T> {
	
	private DataSource dataSource;
	
	public AbstractJdbcrepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

}
