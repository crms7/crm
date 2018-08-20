package com.crm.crm7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.crm")       //加载@Service @Control注解类
@MapperScan("com.crm.dao")      //mybatis 需要扫描dao接口
@EnableTransactionManagement    //启用事务管理
@EnableWebMvc
public class Crm7Application {

    public static void main(String[] args) {
        SpringApplication.run(Crm7Application.class, args);
    }
}
