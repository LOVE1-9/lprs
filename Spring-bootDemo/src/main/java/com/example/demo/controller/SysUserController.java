package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import com.example.demo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户管理", description = "用户 API", position = 100, protocols = "http")

@RestController
@RequestMapping("/")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@GetMapping(value="/findByUserId")
	public SysUser findByUserId(@RequestParam Long userId) {
		return sysUserService.findByUserId(userId);
	}
	@ApiOperation(value = "查询全部" ,  notes="查询全部")
	@GetMapping(value="/findAll")
	public List<SysUser> findAll() {
		return sysUserService.findAll();
	}
	
	@ApiOperation(value="删除用户", notes="根据id来指定删除对象")
	@GetMapping(value="/deleteUserById")
	public void deleteUserById(@RequestParam Long userId) {
		sysUserService.deleteUser(userId);
	}
	
	@GetMapping(value="/updateUser")
	@ApiOperation(value="更改用户")
	public void updateUser(@RequestParam long id,String userName,String mobile) {		
		SysUser record = new SysUser();
		record.setId(id);
		record.setName(userName);
		record.setMobile(mobile);
		record.setCreateTime(new Date());		
		sysUserService.updateUser(record);
	}
	
	@GetMapping(value="/insertUser")
	@ApiOperation(value="添加用户")
	public void insertUser(String userName,String mobile) {		
		SysUser record = new SysUser();
		record.setName(userName);
		record.setMobile(mobile);
		record.setCreateTime(new Date());		
		sysUserService.addUser(record);
	}
	
	@GetMapping(value="/selectByName")
	@ApiOperation(value="按姓名查找用户")
	public SysUser selectByName(String name) {			
		return sysUserService.selectByName(name);
	}
}
