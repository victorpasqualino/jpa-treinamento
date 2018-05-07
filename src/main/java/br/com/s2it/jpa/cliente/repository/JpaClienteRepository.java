package br.com.s2it.jpa.cliente.repository;

import javax.persistence.EntityManager;

import br.com.s2it.jpa.entity.Cliente;
import br.com.s2it.jpa.repository.AbstractJpaRepository;

public class JpaClienteRepository extends AbstractJpaRepository<Long, Cliente> implements ClienteRepository {

	public JpaClienteRepository(EntityManager entityManager) {
		super(entityManager, Cliente.class);
	}

	@Override
	public Cliente findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
