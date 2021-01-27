package com.epam.training.library.repository;

import com.epam.training.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserNameAndActiveTrue(String userName);
    Optional<User> findByUserNameAndActiveFalse(String userName);
}
