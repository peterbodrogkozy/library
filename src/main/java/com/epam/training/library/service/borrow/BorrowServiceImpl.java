package com.epam.training.library.service.borrow;

import com.epam.training.library.model.Borrow;
import com.epam.training.library.model.User;
import com.epam.training.library.repository.BorrowRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl implements BorrowService {
	
	private BorrowRepository borrowRepository;
	
	public BorrowServiceImpl(BorrowRepository borrowRepository) {
		this.borrowRepository = borrowRepository;
	}
	
    @Override
    public JpaRepository<Borrow, Long> getRepository() {
    	return borrowRepository;
    }
    
    @Override
    public void extend(Long borrowId, User user) {
    	Borrow borrow = borrowRepository.findById(borrowId).orElseThrow(() -> new IllegalArgumentException("No borrow found with id:" + borrowId));
    	
    	if(borrow.getUser().getId() == user.getId()) {
        	borrowRepository.save(borrow.extend());	
    	} else {
    		new IllegalArgumentException("Borrow with id:" + borrowId + "belongs to another user.");
    	}
    }

	@Override
	public List<Borrow> getBorrowsForUser(User user) {
		return borrowRepository.findAllByUser(user);
	}
}
