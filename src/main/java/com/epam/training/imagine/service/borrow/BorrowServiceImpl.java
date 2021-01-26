package com.epam.training.imagine.service.borrow;

import com.epam.training.imagine.model.Borrow;
import com.epam.training.imagine.model.User;
import com.epam.training.imagine.repository.BorrowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl implements BorrowService {
	
	@Autowired
	private BorrowRepository borrowRepository;
	
    @Override
    public JpaRepository<Borrow, Long> getRepository() {
    	return borrowRepository;
    }
    
    @Override
    public void extend(Long borrowId, User user) {
    	
    }
}
