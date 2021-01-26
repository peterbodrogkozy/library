package com.epam.training.imagine.service.book;

import java.util.Optional;

import com.epam.training.imagine.model.Book;
import com.epam.training.imagine.service.GenericBusinessService;

public interface BookService extends GenericBusinessService<Book, Long> {

	Optional<Book> search(String author, String title);
	
}
