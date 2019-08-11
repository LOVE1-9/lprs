package com.example.demo.service.impl;

import com.example.demo.mapper.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {
    @Autowired
    private UsersMapper userMapper;

    public UserServiceImpl() {
        super();
    }

    @Override
    public Users findByUserName(String userName) {
        return userMapper.selectByPrimaryKey(userName);

    }

    @Override
    public List<Users> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public void addUser(Users record) {
        userMapper.insert(record);
    }

    @Override
    public void deleteUser(String userName) {
        userMapper.deleteByPrimaryKey(userName);
    }

    @Override
    public void updateUser(Users record) {
        userMapper.updateByPrimaryKey(record);
    }
}
