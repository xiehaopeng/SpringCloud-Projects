package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



//提供Restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixQueryById")    //设置熔断机制，调用hystrixQueryById方法快速返回
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if(dept==null){         //查询为空时抛出错误
            throw new RuntimeException();
        }
        return dept;
    }

    public Dept hystrixQueryById(Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("没有对应的信息，触发Hystrix")
                .setDb_source("在MySQL中没有对应的数据库");
    }


}
