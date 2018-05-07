package br.com.s2it.jpa.repository;

import javax.sql.DataSource;

public interface JdbcRepository<I, T> extends Repository<I, T> {
	
	DataSource getDataSource();

}
