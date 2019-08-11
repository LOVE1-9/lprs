package com.example.demo.mapper;

import com.example.demo.model.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    int deleteByPrimaryKey(String username);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String userName);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> selectAll();
}