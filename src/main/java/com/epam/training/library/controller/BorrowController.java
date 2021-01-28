package com.epam.training.library.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.model.Borrow;
import com.epam.training.library.model.User;
import com.epam.training.library.service.borrow.BorrowService;
import com.epam.training.library.service.user.UserService;

@RestController
@RequestMapping("/user/{userId}")
@PreAuthorize("#id == authentication.principal.id")
public class BorrowController {

	private BorrowService borrowService;
	private UserService userService;
	
	public BorrowController(BorrowService borrowService, UserService userService) {
		this.borrowService = borrowService;
		this.userService = userService;
	}
	
	@GetMapping("/borrows")
    public List<Borrow> getAllBorrowsForUser(@PathVariable(value = "userId") Long userId) {
    	User user = userService.findById(userId);
    	return borrowService.getBorrowsForUser(user);
    }

    @PostMapping("/borrows/{borrowId}/extend")
    public void extend(@PathVariable(value = "userId") Long userId, @PathVariable(value = "borrowId") Long borrowId) {
    	User user = userService.findById(userId);
    	borrowService.extend(borrowId, user);
    }
    
}
