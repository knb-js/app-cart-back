package app.cart.back.service;

import app.cart.back.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAllUser();

    UserEntity findByUser(Integer rut);

    Integer addUser(UserEntity userEntity);

    Integer updateUser(UserEntity userEntity);

    Integer deleteByRut(Integer rut);
}
