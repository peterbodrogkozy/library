package com.epam.training.library.service.book;

import com.epam.training.library.model.Book;
import com.epam.training.library.model.User;
import com.epam.training.library.repository.BookRepository;
import com.epam.training.library.service.borrow.BorrowService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	private BorrowService borrowService;
	
	private BookRepository bookRepository;
	
	public BookServiceImpl(BorrowService borrowService, BookRepository bookRepository) {
		this.borrowService = borrowService;
		this.bookRepository = bookRepository;
	}
	
    @Override
    public JpaRepository<Book, Long> getRepository() {
    	return bookRepository;
    }
    
    @Override
    public Optional<Book> search(String author, String title) {
    	return Optional.empty();
    }

	@Override
	public List<Book> getBooksForUser(User user) {
		List<Long> bookIds = borrowService.getBorrowsForUser(user).stream()
				.map(borrow -> borrow.getBook().getId())
				.collect(Collectors.toList());
		return bookRepository.findByIdIn(bookIds);
	}
}
