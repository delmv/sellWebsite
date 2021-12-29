package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.UserEntity;
import com.spring.henallux.transpLux.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity userModelToUserEntity(User user) {

        Mapper mapper = new DozerBeanMapper();

        UserEntity entity = mapper.map(user, UserEntity.class);

        return entity;

    }

    public User userEntityToUserModel(UserEntity userEntity) {

        Mapper mapper = new DozerBeanMapper();

        User user = mapper.map(userEntity, User.class);

        return user;

    }

}
