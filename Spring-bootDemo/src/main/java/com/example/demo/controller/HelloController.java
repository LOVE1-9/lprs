package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "desc of class")
@RestController
public class HelloController {
	@Value("${my.name}")
	private String name;

	@Value("${my.age}")
	private String age;

	@ApiOperation(value="desc of method",notes="")
	@GetMapping("/hello")	
	public Object hello(@ApiParam(value="desc of param",required=true) @RequestParam(required = false) String name) {
		return "Hello "+name+"!";
	}

	@GetMapping("/String")	
	public String getString(){
		return name.concat(age);
				
	}
}
