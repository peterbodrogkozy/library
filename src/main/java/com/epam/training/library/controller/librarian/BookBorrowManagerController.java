package com.epam.training.library.controller.librarian;

import com.epam.training.library.model.Borrow;
import com.epam.training.library.service.GenericBusinessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarian/borrows")
public class BookBorrowManagerController extends AbstractRestController<Borrow, Long> {
    public BookBorrowManagerController(GenericBusinessService<Borrow, Long> bookBorrowManagerServiceImpl) {
        super(bookBorrowManagerServiceImpl);
    }
}
