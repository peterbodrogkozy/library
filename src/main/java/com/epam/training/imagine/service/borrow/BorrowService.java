package com.epam.training.imagine.service.borrow;

import com.epam.training.imagine.model.Borrow;
import com.epam.training.imagine.model.User;
import com.epam.training.imagine.service.GenericBusinessService;

public interface BorrowService extends GenericBusinessService<Borrow, Long> {
    
    void extend(Long borrowId, User user);
}
