package com.example.demo.service;
import com.example.demo.model.Users;
import java.util.List;
public interface UsersService {
    Users findByUserName(String userName);

    List<Users> findAll();

    void addUser(Users record);

    void deleteUser(String userName);

    void updateUser(Users record);
}

