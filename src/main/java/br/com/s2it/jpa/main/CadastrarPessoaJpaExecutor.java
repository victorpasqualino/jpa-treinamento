package br.com.s2it.jpa.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.s2it.jpa.entity.Pessoa;
import br.com.s2it.jpa.entity.PessoaFisica;
import br.com.s2it.jpa.pessoa.repository.JpaPessoaRepository;
import br.com.s2it.jpa.pessoa.repository.PessoaRepository;

@Service
public class CadastrarPessoaJpaExecutor {
	
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	public CadastrarPessoaJpaExecutor(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	public void execute() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Pessoa find = entityManager.find(Pessoa.class, 1L);
		
		find.setNome("Teste");
		
		System.out.println(find);
		
		transaction.commit();
		
		entityManager.close();
	}

}
