package com.jk.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.UserModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

}
