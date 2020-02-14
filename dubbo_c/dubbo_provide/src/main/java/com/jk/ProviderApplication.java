package com.jk;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jk.mapper")
@EnableDubboConfiguration//识别dubbo的相关注解
public class ProviderApplication {

    public static void main(String[] args)  {
        SpringApplication.run(ProviderApplication.class, args);
        System.out.println("服务端启动成功！！！");
    }
}
