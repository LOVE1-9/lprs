package com.example.demo.service.impl;
import java.util.List;

import com.example.demo.mapper.SysUserMapper;
import com.example.demo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public void addUser(SysUser record) {
		sysUserMapper.insert(record);
	}

	@Override
	public void deleteUser(Long userId) {
		sysUserMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public void updateUser(SysUser record) {
		sysUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public SysUser selectByName(String name) {
		return sysUserMapper.selectByName(name);
	}
	
}
