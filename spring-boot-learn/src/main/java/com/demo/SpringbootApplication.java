package com.demo;


import com.demo.config.AppProp;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 该注解指定项目为springboot，由此类当作程序入口
 * 自动装配 web 依赖的环境
 **/
@MapperScan("com.demo.*.mapper")  //扫描mapper
@EnableAutoConfiguration
@EnableCaching
@SpringBootApplication
public class SpringbootApplication {
    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(SpringbootApplication.class, args);
        AppProp appProp = context.getBean(AppProp.class);
        appProp.toString();
    }
}