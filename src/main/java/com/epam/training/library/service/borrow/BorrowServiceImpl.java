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
    	
    }

	@Override
	public List<Borrow> getBorrowsForUser(User user) {
		return borrowRepository.findAllByUser(user);
	}
}
