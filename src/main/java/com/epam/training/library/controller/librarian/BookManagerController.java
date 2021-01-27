package com.epam.training.library.controller.librarian;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.model.Book;
import com.epam.training.library.service.GenericBusinessService;

@RestController
@RequestMapping("/librarian/books")
public class BookManagerController extends AbstractRestController<Book, Long>{
	
    public BookManagerController(GenericBusinessService<Book, Long> bookService) {
    	super(bookService);
    }
}
