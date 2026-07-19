package com.mybatis.service;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServicelmpl implements UserService{

    @Resource
    private UserMapper userMapper;


    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    @Override
    public List<User> getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

}
