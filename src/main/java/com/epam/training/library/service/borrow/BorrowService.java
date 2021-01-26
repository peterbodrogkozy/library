package com.epam.training.library.service.borrow;

import com.epam.training.library.model.Borrow;
import com.epam.training.library.model.User;
import com.epam.training.library.service.GenericBusinessService;

public interface BorrowService extends GenericBusinessService<Borrow, Long> {
    
    void extend(Long borrowId, User user);
}
