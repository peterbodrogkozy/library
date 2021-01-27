package com.epam.training.library.repository;

import com.epam.training.library.model.Borrow;
import com.epam.training.library.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {
	List<Borrow> findAllByUser(User user);
}
