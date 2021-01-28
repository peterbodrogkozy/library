package com.epam.training.library.service.user;

import com.epam.training.library.model.User;
import com.epam.training.library.service.GenericBusinessService;

public interface UserService extends GenericBusinessService<User, Long> {
	
	User getByUserName(String userName);
	void update(User userInRequest, User existingUser);
	void suspend(Long userId);
	void unSuspend(String userName, String password);
}
