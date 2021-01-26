package com.epam.training.imagine.controller.librarian;

import com.epam.training.imagine.model.User;
import com.epam.training.imagine.service.GenericBusinessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarian/users")
public class UserManagerController extends AbstractRestController<User, Long> {
    public UserManagerController(GenericBusinessService<User, Long> userService) {
        super(userService);
    }
}
