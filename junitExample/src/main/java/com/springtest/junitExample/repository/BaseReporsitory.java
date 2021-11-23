package com.springtest.junitExample.repository;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseReporsitory<T, ID> extends Repository<T, ID> {

	T save(T persisted);
	void delete(T deleted);
	Optional<T> findById(ID id);
	 
}
