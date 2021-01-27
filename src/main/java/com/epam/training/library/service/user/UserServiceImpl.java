package com.epam.training.library.service.user;

import com.epam.training.library.model.User;
import com.epam.training.library.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
    @Override
    public JpaRepository<User, Long> getRepository() {
    	return userRepository;
    }

	@Override
	public User getByUserName(String userName) {
		return getActiveUserByUserName(userName);
	}

	@Override
	public void suspend(String userName) {
		User user = getActiveUserByUserName(userName);
		user.setActive(false);
		userRepository.save(user);
	}
	
	private User getActiveUserByUserName(String userName) {
		return userRepository.findByUserNameAndActiveTrue(userName).orElseThrow(
				() -> new UsernameNotFoundException("User not found or suspended: " + userName));
	}
	
	@Override 
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

	@Override
	public void update(User userInRequest, User existingUser) {
		existingUser.setFullName(userInRequest.getFullName());
		existingUser.setPassword(passwordEncoder.encode(userInRequest.getPassword()));
		existingUser.setUserName(userInRequest.getUserName());
		existingUser.setEmailAddress(userInRequest.getEmailAddress());
		userRepository.save(existingUser);
	}

	@Override
	public void unSuspend(String userName, String password) {
		User user = userRepository.findByUserNameAndActiveFalse(userName).orElseThrow(
				() -> new IllegalArgumentException("User not found or not suspended: " + userName));
		if(passwordEncoder.matches(password, user.getPassword())) {
			user.setActive(true);
			userRepository.save(user);
		} else {
			throw new IllegalArgumentException(); //Custom exception (something like incorrect password) to catch by ControllerAdvice
		}
	}
    
}
