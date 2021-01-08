package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient     //客户端
@RibbonClient(name = "springcloud-provider-dept")   //启动时使用Ribbon对服务名为springcloud-provider-dept的服务实现负载均衡，可以增加configuration属性来配置负载均衡的策略
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
