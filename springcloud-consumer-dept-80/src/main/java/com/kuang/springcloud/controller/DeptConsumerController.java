package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    //消费者Module内不应该有Service层，需要与Service层解耦
    //使用Restful风格请求  SpringBoot内部有RestTemplate供我们直接注册到Spring中调用
    //（url, 实体Map, Class<T> responseType）
    @Autowired  //注入使用
    private RestTemplate restTemplate;  //提供多种便捷访问远程http服务的方法，简单的Restful服务模版

    //Ribbon与Eureka整合实现负载均衡时，这里的地址前缀可以直接使用服务提供者的spring.application.name，多个相同的服务需要公用同一个服务名才能实现负载均衡
    //private static final String REST_URL_PREFIX = "http://localhost:8001";不用ribbon的情况
    private static final String REST_URL_PREFIX = "http://springcloud-provider-dept";


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

}
