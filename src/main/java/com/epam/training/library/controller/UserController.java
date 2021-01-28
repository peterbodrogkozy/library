package com.epam.training.library.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.controller.dto.UserNamePasswordPair;
import com.epam.training.library.model.User;
import com.epam.training.library.service.user.UserService;

@RestController
@RequestMapping("/user/{id}")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
    @GetMapping("/information")
    @PreAuthorize("#id == authentication.principal.id")
    @ResponseBody
    public User currentPerson(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }
    
    @PutMapping("/update")
    @PreAuthorize("#id == authentication.principal.id")
    public void update(@PathVariable(value = "id") Long id, @RequestBody User userInRequest) {
        User existingUser = userService.findById(id);
        userService.update(userInRequest, existingUser);
    }

    @PutMapping("/suspend")
    @PreAuthorize("#id == authentication.principal.id")
    public void suspend(@PathVariable(value = "id") Long id) {
    	userService.suspend(id);

    	SecurityContextHolder.getContext().setAuthentication(null);
    }
    
	@PutMapping
    public void unsuspend(@RequestBody UserNamePasswordPair userNamePasswordPair) {
    	userService.unSuspend(userNamePasswordPair.getUserName(), userNamePasswordPair.getPassword());
    }
}
