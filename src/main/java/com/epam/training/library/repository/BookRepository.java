package com.epam.training.library.repository;

import com.epam.training.library.model.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByIdIn(List<Long> bookIds);
	List<Book> findByTitleContainingIgnoreCase(String title);
}
