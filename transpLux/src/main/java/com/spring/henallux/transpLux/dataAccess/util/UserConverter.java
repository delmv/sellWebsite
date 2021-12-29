package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.UserEntity;
import com.spring.henallux.transpLux.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private Mapper mapper = new DozerBeanMapper();

    public UserEntity userModelToUserEntity(User user) {
        return mapper.map(user, UserEntity.class);
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        return mapper.map(userEntity, User.class);
    }

}
