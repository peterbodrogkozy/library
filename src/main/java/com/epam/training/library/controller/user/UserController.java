package com.epam.training.library.controller.user;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.training.library.controller.dto.UserNamePasswordPair;
import com.epam.training.library.model.Book;
import com.epam.training.library.model.User;
import com.epam.training.library.security.auth.UserPrincipal;
import com.epam.training.library.service.book.BookService;
import com.epam.training.library.service.user.UserService;

@RestController
@RequestMapping("/user/me")
public class UserController {

	private UserService userService;
	private BookService bookService;
	
	public UserController(UserService userService, BookService bookService) {
		this.userService = userService;
		this.bookService = bookService;
	}
	
    @GetMapping("/information")
    @ResponseBody
    public String currentPerson(Authentication authentication) {
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
       // return userService.getByUserName(principal.getUsername());
        return String.valueOf(principal.getAuthorities());
    }
    
    @GetMapping("/books")
    @ResponseBody
    public List<Book> getBooks(Authentication authentication) {
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        User user = userService.getByUserName(principal.getUsername());
        return bookService.getBooksForUser(user);
    }
    
    @PutMapping("/update")
    public void update(@RequestBody User userInRequest, Authentication authentication) {
    	UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        User existingUser = userService.getByUserName(principal.getUsername());
        userService.update(userInRequest, existingUser);
    }

    @PostMapping("/suspend")
    public void suspend(Authentication authentication) {
    	UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
    	userService.suspend(principal.getUsername());
    	
    	SecurityContextHolder.getContext().setAuthentication(null);
    }
    
    @PostMapping("/unsuspend")
    public void suspend(@RequestBody UserNamePasswordPair userNamePasswordPair) {
    	userService.unSuspend(userNamePasswordPair.getUserName(), userNamePasswordPair.getPassword());
    }
}
