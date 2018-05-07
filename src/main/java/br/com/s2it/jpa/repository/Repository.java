package br.com.s2it.jpa.repository;

import java.util.List;

public interface Repository<I, T> {
	
	T gravar(T t);
	
	T update(T t);
	
	void remove(T t);
	
	T findById(I id);

	List<T> findAll();
	
}
