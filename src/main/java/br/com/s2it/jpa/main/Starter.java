package br.com.s2it.jpa.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Starter {
	
	private static final String PERSISTENCE_UNIT_NAME = "treinamentoPU";
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
	
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		new CadastrarClienteExecutor().execute(entityManagerFactory);
	
	}

}
