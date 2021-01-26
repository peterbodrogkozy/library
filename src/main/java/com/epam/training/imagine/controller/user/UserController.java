package com.epam.training.imagine.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/information")
    @ResponseBody
    public String currentPerson(Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        return String.valueOf(principal.getAuthorities());
    }

    /*
    @PostMapping("/suspend")

    @GetMapping("/information")

    @PostMapping

     */
}
