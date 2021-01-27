package com.epam.training.library.service.book;

import java.util.List;
import java.util.Optional;

import com.epam.training.library.model.Book;
import com.epam.training.library.model.User;
import com.epam.training.library.service.GenericBusinessService;

public interface BookService extends GenericBusinessService<Book, Long> {

	Optional<Book> search(String author, String title);
	List<Book> getBooksForUser(User user);
}
