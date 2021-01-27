package com.epam.training.library.controller.librarian;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.model.Borrow;
import com.epam.training.library.service.GenericBusinessService;

@RestController
@RequestMapping("/librarian/borrows")
@PreAuthorize("hasRole('ROLE_LIBRARIAN')")
public class BorrowManagerController extends AbstractRestController<Borrow, Long>{
	
    public BorrowManagerController(GenericBusinessService<Borrow, Long> borrowService) {
    	super(borrowService);
    }

}
