package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.dataAccess.entity.UserEntity;
import com.spring.henallux.transpLux.dataAccess.repository.UserRepository;
import com.spring.henallux.transpLux.dataAccess.util.UserConverter;
import com.spring.henallux.transpLux.exceptions.UserNotFoundException;
import com.spring.henallux.transpLux.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public User getUser(String email, String password) throws UserNotFoundException {

        UserEntity userEntity = userRepository.getUserEntityByEmailAndPassword(email, password);

        if (userEntity == null)
            throw new UserNotFoundException(email);

        User user = userConverter.userEntityToUserModel(userEntity);

        return user;

    }
    @Override
    public User findByUsername(String userName) {
        UserEntity userEntity =  userRepository.findByUsername(userName);
        return userConverter.userEntityToUserModel(userEntity);
    }

}
