package com.epam.training.imagine.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface GenericBusinessService<T, ID> {

	JpaRepository<T, ID> getRepository();
	
    default Iterable<T> findAll() {
        return getRepository().findAll();
    }
    
    default T findById(@NotNull ID id) {
        return getRepository().findById(id).orElseThrow(NullPointerException::new);  //TODO: Custom expection class
    }
    
    default T save(@NotNull @Valid T t) {
        return getRepository().save(t);
    }

    default void remove(@NotNull T t) {
    	getRepository().delete(t);
    }
}
