package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
@ComponentScan(basePackages = {"com.jk.*"})
public class UserController {

    @Reference
    private UserService userService;

}
