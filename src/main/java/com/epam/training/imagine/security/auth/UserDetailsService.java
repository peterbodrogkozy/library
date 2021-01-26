package com.epam.training.imagine.security.auth;


import com.epam.training.imagine.model.User;
import com.epam.training.imagine.repository.UserRepository;
import com.epam.training.imagine.security.model.AuthenticationGroup;
import com.epam.training.imagine.security.repository.AuthenticationGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    private final AuthenticationGroupRepository groupRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public UserDetailsService(UserRepository userRepository,
                              AuthenticationGroupRepository groupRepository) {
        super();
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName)
                                        .orElseThrow(() -> new UsernameNotFoundException("User name not found exception: " + userName));
        List<AuthenticationGroup> groupList = groupRepository.findByUserName(userName);
        LOGGER.info("Logged user: {}, group: {}", user, Arrays.toString(groupList.toArray()));
        return new UserPrincipal(user, groupList);
    }
}
