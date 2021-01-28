package com.epam.training.library.controller.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.controller.dto.UserNamePasswordPair;
import com.epam.training.library.service.user.UserService;

@RestController
@RequestMapping("/user/unsuspend")
public class UnSuspendController {

	private UserService userService;
	
	public UnSuspendController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
    public void unsuspend(@RequestBody UserNamePasswordPair userNamePasswordPair) {
    	userService.unSuspend(userNamePasswordPair.getUserName(), userNamePasswordPair.getPassword());
    }
}
