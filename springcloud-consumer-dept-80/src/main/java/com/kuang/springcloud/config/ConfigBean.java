package com.kuang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //相当于spring中的applicationContext.xml，我们在这个类就可以配置bean
public class ConfigBean {

    @Bean   //注册RestTemplate为Bean,提供多种便捷访问远程http服务的方法
    @LoadBalanced   //ribbon让RestTemplate实现负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
