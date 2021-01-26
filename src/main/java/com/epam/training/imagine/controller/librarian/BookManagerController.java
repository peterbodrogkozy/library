package com.epam.training.imagine.controller.librarian;

import com.epam.training.imagine.model.Book;
import com.epam.training.imagine.service.GenericBusinessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling Librarian action.
 */
@RestController
@RequestMapping("/librarian/books")
public class BookManagerController extends AbstractRestController<Book, Long> {
    public BookManagerController(GenericBusinessService<Book, Long> bookService) {
        super(bookService);
    }
}
