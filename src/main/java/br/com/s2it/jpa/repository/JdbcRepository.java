package br.com.s2it.jpa.repository;

import java.sql.Connection;

public interface JdbcRepository<I, T> extends Repository<I, T> {
	
	Connection getConnection();

}
