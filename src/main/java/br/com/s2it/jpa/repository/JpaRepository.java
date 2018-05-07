package br.com.s2it.jpa.repository;

import javax.persistence.EntityManager;

public interface JpaRepository<I, T> extends Repository<I, T> {
	
	EntityManager getEntityManager();

}
