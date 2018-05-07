package br.com.s2it.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		PessoaRepository pessoaRepository = new JpaPessoaRepository(entityManager);
		
//		List<Pessoa> pessoas = pessoaRepository.findAll();
//		
//		pessoas.forEach(System.out::println);
//		
//		PessoaFisica pessoa = new PessoaFisica();
//		pessoa.setCodigo("22222222222");
//		pessoa.setNome("FULANO DA SILVA");
//		pessoa.setDataNascimento(LocalDate.now());
//		
//		pessoaRepository.gravar(pessoa);
//		
//		pessoas = pessoaRepository.findAll();
//		
//		pessoas.forEach(System.out::println);
//		entityManager.close();
		
	}

}
