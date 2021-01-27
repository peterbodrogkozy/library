package com.epam.training.library.security.auth;


import com.epam.training.library.model.User;
import com.epam.training.library.repository.UserRepository;
import com.epam.training.library.security.model.AuthGroup;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameAndActiveTrue(userName)
                                        .orElseThrow(() -> new UsernameNotFoundException("User not found or suspended: " + userName));

        AuthGroup authGroup = user.isAdmin() ? AuthGroup.LIBRARIAN : AuthGroup.USER;
        return new UserPrincipal(user, authGroup);
    }
}
