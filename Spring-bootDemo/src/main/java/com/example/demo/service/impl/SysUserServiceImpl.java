package com.example.demo.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.model.SysUser;
import com.example.demo.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Override
    public SysUser findByUserId(Long userId) {
    	return sysUserMapper.selectByPrimaryKey(userId);
    }
    
    @Override
    public List<SysUser> findAll(){
    	return sysUserMapper.selectAll();
    }
}
