package com.epam.training.library.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.model.Book;
import com.epam.training.library.model.User;
import com.epam.training.library.service.book.BookService;
import com.epam.training.library.service.user.UserService;

@RestController
public class BookController {

	private BookService bookService;
	private UserService userService;
	
	public BookController(BookService bookService, UserService userService) {
		this.bookService = bookService;
		this.userService = userService;
	}
	
    @GetMapping("/books")
    public List<Book> getAllBooks() {
    	return (List<Book>) bookService.findAll();
    }
     
    @GetMapping("user/{userId}/books")
    @PreAuthorize("#id == authentication.principal.id")
    @ResponseBody
    public List<Book> getBooks(@PathVariable(value = "userId") Long userId) {
        User user = userService.findById(userId);
        return bookService.getBooksForUser(user);
    }
    
    @GetMapping("/books/search")
    public List<Book> searchBook(@RequestParam String title) {
    	return bookService.search(title);
    }
}
