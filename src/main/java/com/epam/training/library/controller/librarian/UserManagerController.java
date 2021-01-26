package com.epam.training.library.controller.librarian;

import com.epam.training.library.model.User;
import com.epam.training.library.service.GenericBusinessService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarian/users")
public class UserManagerController extends AbstractRestController<User, Long> {
    public UserManagerController(GenericBusinessService<User, Long> userService) {
        super(userService);
    }
}
