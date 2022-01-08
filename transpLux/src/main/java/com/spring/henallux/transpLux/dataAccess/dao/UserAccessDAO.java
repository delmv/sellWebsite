package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.exceptions.ErrorOccured;
import com.spring.henallux.transpLux.exceptions.UserNotFoundException;
import com.spring.henallux.transpLux.exceptions.UsernameOrEmailAlreadyExistException;
import com.spring.henallux.transpLux.model.User;

public interface UserAccessDAO {

    void setUser(User user) throws UsernameOrEmailAlreadyExistException, ErrorOccured;
    User findByUsername(String userName);

}
