package com.epam.training.library.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericBusinessService<T, ID> {

	JpaRepository<T, ID> getRepository();
	
    default Iterable<T> findAll() {
        return getRepository().findAll();
    }
    
    default T findById(ID id) {
        return getRepository().findById(id).orElseThrow(IllegalArgumentException::new);  //TODO: Custom expection class
    }
    
    default T save(T t) {
        return getRepository().save(t);
    }

    default void remove(T t) {
    	getRepository().delete(t);
    }
}
