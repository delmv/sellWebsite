package com.spring.henallux.transpLux.services;

import com.spring.henallux.transpLux.dataAccess.dao.UserAccessDAO;
import com.spring.henallux.transpLux.dataAccess.dao.UserDAO;
import com.spring.henallux.transpLux.exceptions.ErrorOccured;
import com.spring.henallux.transpLux.exceptions.UserNotFoundException;
import com.spring.henallux.transpLux.exceptions.UsernameOrEmailAlreadyExistException;
import com.spring.henallux.transpLux.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserAccessDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) throws UsernameOrEmailAlreadyExistException, ErrorOccured {
        userDAO.setUser(user);
    }

    public User findByUsername(String username){
        return userDAO.findByUsername(username);
    }

}
