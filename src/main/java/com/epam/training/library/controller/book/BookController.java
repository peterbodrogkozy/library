package com.epam.training.library.controller.book;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.model.Book;
import com.epam.training.library.service.book.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
    @GetMapping
    public List<Book> getAllBooks() {
    	return (List<Book>) bookService.findAll();
    }
    
    @GetMapping("/search")
    public List<Book> searchBook(@RequestParam String title) {
    	return bookService.search(title);
    }
}
