package br.com.s2it.jpa.cliente.repository;

import br.com.s2it.jpa.entity.Cliente;
import br.com.s2it.jpa.repository.Repository;

public interface ClienteRepository extends Repository<Long, Cliente> {
	
	Cliente findByEmail(String email);
	
	Cliente findByLogin(String login);

}
