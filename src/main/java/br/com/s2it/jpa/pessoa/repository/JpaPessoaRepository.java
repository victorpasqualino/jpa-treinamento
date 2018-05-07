package br.com.s2it.jpa.pessoa.repository;

import javax.persistence.EntityManager;

import br.com.s2it.jpa.entity.Pessoa;
import br.com.s2it.jpa.repository.AbstractJpaRepository;

public class JpaPessoaRepository extends AbstractJpaRepository<Long, Pessoa> implements PessoaRepository {
	
	public JpaPessoaRepository(EntityManager entityManager) {
		super(entityManager, Pessoa.class);
	}

	@Override
	public Pessoa findByCodigo(String codigo) {
		throw new UnsupportedOperationException("Not Implemented");
	}
	
}
