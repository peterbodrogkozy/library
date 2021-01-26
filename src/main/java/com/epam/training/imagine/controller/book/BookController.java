package com.epam.training.imagine.controller.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.imagine.model.Book;
import com.epam.training.imagine.model.Borrow;
import com.epam.training.imagine.model.User;
import com.epam.training.imagine.service.book.BookService;
import com.epam.training.imagine.service.borrow.BorrowService;
import com.epam.training.imagine.service.subscription.SubscriptionService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BorrowService borrowService;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	//TODO: validator
	
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
    public @ResponseBody void extend(@PathVariable Long borrowId, @AuthenticationPrincipal User user) {
    	borrowService.extend(borrowId, user);
    }
    
    @PostMapping("/{id}/subscribe")
    public @ResponseBody void subscribe(@PathVariable Long bookId, @AuthenticationPrincipal User user) {
    	subscriptionService.subscribe(bookId, user);
    }
}
