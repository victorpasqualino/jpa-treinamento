package br.com.s2it.jpa.pessoa.repository;

import java.sql.Connection;
import java.util.List;

import br.com.s2it.jpa.entity.Pessoa;
import br.com.s2it.jpa.repository.AbstractJdbcrepository;

public class JdbcPessoaRepository extends AbstractJdbcrepository<Long, Pessoa> implements PessoaRepository {
	
	public JdbcPessoaRepository(Connection connection) {
		super(connection);
	}

	@Override
	public Pessoa gravar(Pessoa pessoa) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public Pessoa findById(Long id) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public void remove(Pessoa pessoa) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public List<Pessoa> findAll() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public Pessoa findByCodigo(String codigo) {
		throw new UnsupportedOperationException("Not Implemented");
	}

}
