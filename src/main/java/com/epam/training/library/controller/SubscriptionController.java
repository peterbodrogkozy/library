package com.epam.training.library.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.model.User;
import com.epam.training.library.service.subscription.SubscriptionService;
import com.epam.training.library.service.user.UserService;

@RestController
@RequestMapping("/user/{userId}")
@PreAuthorize("#id == authentication.principal.id")
public class SubscriptionController {
	
	private SubscriptionService subscriptionService;
	private UserService userService;
	
	public SubscriptionController(SubscriptionService subscriptionService, UserService userService) {
		this.subscriptionService = subscriptionService;
		this.userService = userService;
	}
	
	@PostMapping("/books/{bookId}/subscribe")
    public void subscribe(@PathVariable(value = "userId") Long userId, @PathVariable(value = "bookId") Long bookId) {
    	User user = userService.findById(userId);
    	subscriptionService.subscribe(bookId, user);
    }
}
