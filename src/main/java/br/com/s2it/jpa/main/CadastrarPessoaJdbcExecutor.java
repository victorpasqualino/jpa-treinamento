package br.com.s2it.jpa.main;

import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import br.com.s2it.jpa.entity.PessoaFisica;
import br.com.s2it.jpa.pessoa.repository.JdbcPessoaRepository;
import br.com.s2it.jpa.pessoa.repository.PessoaRepository;

@Service
public class CadastrarPessoaJdbcExecutor {
	
	private DataSource dataSource;
	
	public CadastrarPessoaJdbcExecutor(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void execute() {
		
		PessoaRepository pessoaRepository = new JdbcPessoaRepository(dataSource);
		
		PessoaFisica pessoa = new PessoaFisica();
		pessoa.setCodigo("22222222222");
		pessoa.setNome("FULANO DA SILVA");
		pessoa.setDataNascimento(LocalDate.now());
		
		pessoaRepository.gravar(pessoa);
		
	}

}
