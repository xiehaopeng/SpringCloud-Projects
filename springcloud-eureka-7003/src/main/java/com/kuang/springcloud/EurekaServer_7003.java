package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动之后访问http://${eureka.instance.hostname}:${server.port}即可进入监控界面
@SpringBootApplication
@EnableEurekaServer     //EnableEurekaServer 服务端启动类，可以接受别人注册进来
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class,args);
    }
}
