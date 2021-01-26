package com.epam.training.imagine.security.repository;

import com.epam.training.imagine.security.model.AuthenticationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthenticationGroupRepository extends JpaRepository<AuthenticationGroup, Long> {
    List<AuthenticationGroup> findByUserName(String userName);
}
