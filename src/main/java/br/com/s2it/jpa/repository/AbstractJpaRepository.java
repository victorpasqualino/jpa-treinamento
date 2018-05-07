package br.com.s2it.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractJpaRepository<I, T> implements JpaRepository<I, T> {
	
	private EntityManager entityManager;
	private Class<T> entityClass;
	
	public AbstractJpaRepository(EntityManager entityManager, Class<T> entityClass) {
		this.entityManager = entityManager;
		this.entityClass = entityClass;
	}
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public T gravar(T t) {
		EntityTransaction transaction = getEntityManager().getTransaction();
		boolean active = transaction.isActive();
		if (!transaction.isActive()) {
			getEntityManager().getTransaction().begin();
		}
		getEntityManager().persist(t);
		if (!active) {
			transaction.commit();
		}
		return t;
	}
	
	@Override
	public void remove(T t) {
		getEntityManager().remove(t);
	}
	
	@Override
	public T update(T t) {
		return getEntityManager().merge(t);
	}
	
	@Override
	public T findById(I id) {
		return getEntityManager().find(entityClass, id);
	}
	
	@Override
	public List<T> findAll() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> from = cq.from(entityClass);
		cq.select(from);
		return getEntityManager().createQuery(cq).getResultList();
	}
	
	

}
