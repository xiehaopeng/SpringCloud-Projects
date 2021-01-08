package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//启动类
@SpringBootApplication
@EnableEurekaClient     //在服务启动后自动注册到EurekaServer中
public class DeptProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(com.kuang.springcloud.DeptProvider_8002.class,args);
    }
}