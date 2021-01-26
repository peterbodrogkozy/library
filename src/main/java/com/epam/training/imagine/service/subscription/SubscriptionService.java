package com.epam.training.imagine.service.subscription;

import com.epam.training.imagine.model.Subscription;
import com.epam.training.imagine.model.User;
import com.epam.training.imagine.service.GenericBusinessService;

public interface SubscriptionService extends GenericBusinessService<Subscription, Long> {
	
	void subscribe(Long bookId, User user);

}
