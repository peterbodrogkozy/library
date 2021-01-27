package com.epam.training.library.controller.book;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.model.Book;
import com.epam.training.library.model.Borrow;
import com.epam.training.library.model.User;
import com.epam.training.library.service.book.BookService;
import com.epam.training.library.service.borrow.BorrowService;
import com.epam.training.library.service.subscription.SubscriptionService;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	private BorrowService borrowService;
	private SubscriptionService subscriptionService;
	
	public BookController(BookService bookService, BorrowService borrowService, SubscriptionService subscriptionService) {
		this.bookService = bookService;
		this.borrowService = borrowService;
		this.subscriptionService = subscriptionService;
	}
	
    @GetMapping
    public List<Book> getAllBooks() {
    	return (List<Book>) bookService.findAll();
    }
    
    @GetMapping("/search")
    public Book searchBook(@RequestParam(required = false) String author, @RequestParam String title) {
    	return bookService.search(author, title).get();
    }
    
    @GetMapping("/borrows")
    public List<Borrow> getAllBorrowsForUser(@AuthenticationPrincipal User user) {
    	return (List<Borrow>) borrowService.findAll();
    }

    @PostMapping("/borrows/{id}/extend")
    public void extend(@PathVariable Long borrowId, @AuthenticationPrincipal User user) {
    	borrowService.extend(borrowId, user);
    }
    
    @PostMapping("/{id}/subscribe")
    public void subscribe(@PathVariable Long bookId, @AuthenticationPrincipal User user) {
    	subscriptionService.subscribe(bookId, user);
    }
}
