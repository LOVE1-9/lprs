package com.example.demo.service;
import java.util.List;
import com.example.demo.model.SysUser;

public interface SysUserService {

	SysUser findByUserId(Long userId);
	List<SysUser> findAll();
	
}
