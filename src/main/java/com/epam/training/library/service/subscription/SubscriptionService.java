package com.epam.training.library.service.subscription;

import com.epam.training.library.model.Subscription;
import com.epam.training.library.model.User;
import com.epam.training.library.service.GenericBusinessService;

public interface SubscriptionService extends GenericBusinessService<Subscription, Long> {
	
	void subscribe(Long bookId, User user);

}
