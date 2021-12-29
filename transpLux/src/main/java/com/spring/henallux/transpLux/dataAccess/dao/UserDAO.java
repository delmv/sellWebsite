package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.dataAccess.entity.UserEntity;
import com.spring.henallux.transpLux.dataAccess.repository.UserRepository;
import com.spring.henallux.transpLux.dataAccess.util.UserConverter;
import com.spring.henallux.transpLux.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO implements UserDataAccess {

    private UserRepository userRepository;
    private UserConverter userConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }


    @Override
    public void setUser(User user) {

        UserEntity userEntity = userConverter.userModelToUserEntity(user);

        userRepository.save(userEntity);

    }

    @Override
    public User getUser(String email, String password) {
        return null;
    }
}
