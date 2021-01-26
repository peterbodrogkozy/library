package com.epam.training.imagine.security.auth;


import com.epam.training.imagine.model.User;
import com.epam.training.imagine.security.model.AuthenticationGroup;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 5812265126493595069L;
	
	private final User user;
    private final List<AuthenticationGroup> authenticationGroups;

    public UserPrincipal(User user, List<AuthenticationGroup> authenticationGroups) {
        super();
        this.user = user;
        this.authenticationGroups = authenticationGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authenticationGroups.stream()
                                   .map(AuthenticationGroup::getAuthGroup)
                                   .map(SimpleGrantedAuthority::new)
                                   .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
