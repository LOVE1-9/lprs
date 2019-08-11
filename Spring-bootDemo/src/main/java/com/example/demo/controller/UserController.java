package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import com.example.demo.service.*;

import java.util.*;


@CrossOrigin
@Api(value = "登陆")
@RestController
public class UserController {
    @Autowired
    private UsersService userService;

    @PostMapping(value = "api/login")
    public Result login(@RequestBody Users requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username, password ;
        username = HtmlUtils.htmlEscape(requestUser.getUsername());
        Users user = userService.findByUserName(username);
        if (user!=null) {
            password = user.getPassword();
            if (Objects.equals(password, requestUser.getPassword())) {
                System.out.println("login: "+username + " " + password);
                Map<String, String> data = new HashMap<>();
                String token = "admin-token";
                data.put("token", token);
                return new Result(20000, data, null);
            }
        }
        String message = "账号密码错误";
        Map<String, String> data = new HashMap<>();
        return new Result(60204, data, "账号密码错误");
    }

    @PostMapping(value = "api/register")
    public Result register(@RequestBody Users requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        String password = requestUser.getPassword();
        System.out.println("register: " + username + " " + password);
        Users user = userService.findByUserName(username);
        if (user==null) {
            userService.addUser(new Users(username,password,"admin"));
            return new Result(20001, null, "注册成功");
        }
        return new Result(60240, null, "注册失败，用户已存在");
    }


}

