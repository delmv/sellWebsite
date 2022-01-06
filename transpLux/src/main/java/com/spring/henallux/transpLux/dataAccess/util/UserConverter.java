package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.UserEntity;
import com.spring.henallux.transpLux.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private Mapper mapper = new DozerBeanMapper();

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setMale(user.getMale());
        userEntity.setCity(user.getCity());
        userEntity.setCountry(user.getCountry());
        userEntity.setZipCode(user.getZipCode());
        userEntity.setFavoriteAnimal(user.getFavoriteAnimal());
        userEntity.setPhone(user.getPhone());
        userEntity.setAddress(user.getAddress());
        userEntity.setAuthorities("ROLE_USER");
        userEntity.setNonExpired(true);
        userEntity.setNonLocked(true);
        userEntity.setCredentialsNonExpired(true);
        userEntity.setEnabled(true);
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity){
        User user = mapper.map(userEntity, User.class);
        user.setAccountNonExpired(userEntity.getNonExpired());
        user.setAccountNonLocked(userEntity.getNonLocked());
        user.setAuthorities(userEntity.getAuthorities());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled(userEntity.getEnabled());
        return user;
    }

}
