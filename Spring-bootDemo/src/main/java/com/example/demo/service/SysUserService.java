package com.example.demo.service;
import com.example.demo.model.SysUser;

import java.util.List;

public interface SysUserService {

	SysUser findByUserId(Long userId);
	List<SysUser> findAll();
	void addUser(SysUser record);
	void deleteUser(Long userId);
	void updateUser(SysUser record);
	SysUser selectByName(String name);

}
