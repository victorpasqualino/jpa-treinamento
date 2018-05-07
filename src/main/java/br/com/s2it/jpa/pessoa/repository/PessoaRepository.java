package br.com.s2it.jpa.pessoa.repository;

import br.com.s2it.jpa.entity.Pessoa;
import br.com.s2it.jpa.repository.Repository;

public interface PessoaRepository extends Repository<Long, Pessoa> {
	
	Pessoa findByCodigo(String codigo);

}
