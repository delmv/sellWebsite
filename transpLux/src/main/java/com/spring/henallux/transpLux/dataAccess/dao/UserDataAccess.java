package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.exceptions.UserNotFoundException;
import com.spring.henallux.transpLux.model.User;

import java.util.ArrayList;

public interface UserDataAccess {

    void setUser(User user);
    User getUser(String email, String password) throws UserNotFoundException;

}
