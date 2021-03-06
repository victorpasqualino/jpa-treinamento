package br.com.s2it.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.s2it.jpa.cliente.repository.ClienteRepository;
import br.com.s2it.jpa.cliente.repository.JpaClienteRepository;
import br.com.s2it.jpa.entity.Cliente;
import br.com.s2it.jpa.pessoa.repository.JpaPessoaRepository;
import br.com.s2it.jpa.pessoa.repository.PessoaRepository;

@Service
public class CadastrarClienteExecutor {
	
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	public CadastrarClienteExecutor(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	public void execute() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		PessoaRepository pessoaRepository = new JpaPessoaRepository(entityManager);
		ClienteRepository clienteRepository = new JpaClienteRepository(entityManager);
		
		Cliente cliente = new Cliente();
		cliente.setEmail("fulano@email.com.br");
		
	}

}
