package app.cart.back.service.impl;

import app.cart.back.entity.UserEntity;
import app.cart.back.mapper.UserMapper;
import app.cart.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public UserEntity findByUser(Integer rut) {
        return userMapper.findByUser(rut);
    }

    @Override
    public Integer addUser(UserEntity userEntity) {
        return userMapper.addUser(userEntity);
    }

    @Override
    public Integer updateUser(UserEntity userEntity) {
        return userMapper.updateUser(userEntity);
    }

    @Override
    public Integer deleteByRut(Integer rut) {
        return userMapper.deleteByRut(rut);
    }
}
