package com.epam.training.imagine.service.user;

import com.epam.training.imagine.model.User;
import com.epam.training.imagine.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepository userRepository;
	
    @Override
    public JpaRepository<User, Long> getRepository() {
    	return userRepository;
    }
}
