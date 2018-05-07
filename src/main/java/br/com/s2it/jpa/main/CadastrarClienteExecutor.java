package br.com.s2it.jpa.main;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.s2it.jpa.entity.Pessoa;
import br.com.s2it.jpa.entity.PessoaFisica;
import br.com.s2it.jpa.pessoa.repository.JpaPessoaRepository;
import br.com.s2it.jpa.pessoa.repository.PessoaRepository;

public class CadastrarClienteExecutor {
	
	public void execute(EntityManagerFactory entityManagerFactory) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		PessoaRepository pessoaRepository = new JpaPessoaRepository(entityManager);
		
		List<Pessoa> pessoas = pessoaRepository.findAll();
		
		pessoas.forEach(System.out::println);
		
		PessoaFisica pessoa = new PessoaFisica();
		pessoa.setCodigo("22222222222");
		pessoa.setNome("FULANO DA SILVA");
		pessoa.setDataNascimento(LocalDate.now());
		
		pessoaRepository.gravar(pessoa);
		
		pessoas = pessoaRepository.findAll();
		
		pessoas.forEach(System.out::println);
	}

//	private CadastroClienteVo createCadastrarClienteVo() {
//		CadastroClienteVo cadastroClienteVo = new CadastroClienteVo();
//		return null;
//	}

}
