package com.epam.training.imagine.service.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.epam.training.imagine.model.Subscription;
import com.epam.training.imagine.model.User;
import com.epam.training.imagine.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
    @Override
    public JpaRepository<Subscription, Long> getRepository() {
    	return subscriptionRepository;
    }
    
	@Override
	public void subscribe(Long bookId, User user) {
		
	}
}
