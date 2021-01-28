package com.epam.training.library.controller.user;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.model.Book;
import com.epam.training.library.model.Borrow;
import com.epam.training.library.model.User;
import com.epam.training.library.service.book.BookService;
import com.epam.training.library.service.borrow.BorrowService;
import com.epam.training.library.service.subscription.SubscriptionService;
import com.epam.training.library.service.user.UserService;

@RestController
@RequestMapping("/user/{id}")
@PreAuthorize("#id == authentication.principal.id")
public class UserController {

	private UserService userService;
	private BookService bookService;
	private BorrowService borrowService;
	private SubscriptionService subscriptionService;
	
	public UserController(UserService userService, BookService bookService, BorrowService borrowService, SubscriptionService subscriptionService) {
		this.userService = userService;
		this.bookService = bookService;
		this.borrowService = borrowService;
		this.subscriptionService = subscriptionService;
	}
	
    @GetMapping("/information")
    @ResponseBody
    public User currentPerson(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }
    
    @GetMapping("/books")
    @ResponseBody
    public List<Book> getBooks(@PathVariable(value = "id") Long id) {
        User user = userService.findById(id);
        return bookService.getBooksForUser(user);
    }
    
    @PutMapping("/update")
    public void update(@PathVariable(value = "id") Long id, @RequestBody User userInRequest) {
        User existingUser = userService.findById(id);
        userService.update(userInRequest, existingUser);
    }

    @PostMapping("/suspend")
    public void suspend(@PathVariable(value = "id") Long id) {
    	userService.suspend(id);

    	SecurityContextHolder.getContext().setAuthentication(null);
    }
    
    @GetMapping("/borrows")
    public List<Borrow> getAllBorrowsForUser(@PathVariable(value = "id") Long id) {
    	User user = userService.findById(id);
    	return borrowService.getBorrowsForUser(user);
    }

    @PostMapping("/borrows/{borrowId}/extend")
    public void extend(@PathVariable(value = "id") Long id, @PathVariable(value = "borrowId") Long borrowId) {
    	User user = userService.findById(id);
    	borrowService.extend(borrowId, user);
    }
    
    @PostMapping("/books/{bookId}/subscribe")
    public void subscribe(@PathVariable(value = "id") Long id, @PathVariable(value = "bookId") Long bookId) {
    	User user = userService.findById(id);
    	subscriptionService.subscribe(bookId, user);
    }
}
