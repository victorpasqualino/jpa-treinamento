package br.com.s2it.jpa.main;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import br.com.s2it.jpa.main.Starter.AppConfiguration;

@Import({ AppConfiguration.class })
public class Starter {
	
	private static final String PERSISTENCE_UNIT_NAME = "treinamentoPU";
	
	@Autowired
	protected CadastrarPessoaJpaExecutor cadastrarPessoaJpaExecutor;
	@Autowired
	protected CadastrarPessoaJdbcExecutor cadastrarPessoaJdbcExecutor;
	
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}
	
	@PostConstruct
	public void init() {
		cadastrarPessoaJpaExecutor.execute();
//		cadastrarPessoaJdbcExecutor.execute();
	}
	
	@ComponentScan
	public static class AppConfiguration {
		
		@Bean
		public EntityManagerFactory createEntityManagerFactory() {
			return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		
		@Bean
		public DataSource datasource() {
			PGSimpleDataSource dataSource = new PGSimpleDataSource();
			dataSource.setDatabaseName("jpa_treinamento");
			dataSource.setUser("postgres");
			dataSource.setPassword("postgres");
			dataSource.setPortNumber(5432);
			return dataSource;
		}
		
	}

}
