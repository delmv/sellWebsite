package com.spring.henallux.transpLux.dataAccess.dao;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.spring.henallux.transpLux.dataAccess.entity.UserEntity;
import com.spring.henallux.transpLux.dataAccess.repository.UserRepository;
import com.spring.henallux.transpLux.dataAccess.util.UserConverter;
import com.spring.henallux.transpLux.exceptions.ErrorOccured;
import com.spring.henallux.transpLux.exceptions.UserNotFoundException;
import com.spring.henallux.transpLux.exceptions.UsernameOrEmailAlreadyExistException;
import com.spring.henallux.transpLux.model.User;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class UserDAO implements UserAccessDAO {

    private UserRepository userRepository;
    private UserConverter userConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, UserConverter userConverter) {

        this.userRepository = userRepository;
        this.userConverter = userConverter;

    }


    @Override
    public void setUser(User user) throws UsernameOrEmailAlreadyExistException {

        UserEntity userEntity = userConverter.userModelToUserEntity(user);
        try {
            userRepository.save(userEntity);
        } catch(DataIntegrityViolationException e) {
            throw new UsernameOrEmailAlreadyExistException();
        }

    }

    @Override
    public User findByUsername(String userName) {
        UserEntity userEntity =  userRepository.findByUsername(userName);
        return userConverter.userEntityToUserModel(userEntity);
    }

}
