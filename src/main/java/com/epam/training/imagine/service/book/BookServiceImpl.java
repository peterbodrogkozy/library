package com.epam.training.imagine.service.book;

import com.epam.training.imagine.model.Book;
import com.epam.training.imagine.repository.BookRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
    @Override
    public JpaRepository<Book, Long> getRepository() {
    	return bookRepository;
    }
    
    @Override
    public Optional<Book> search(String author, String title) {
    	return Optional.empty();
    }
}
