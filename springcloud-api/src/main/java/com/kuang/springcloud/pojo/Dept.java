package com.kuang.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data                   //get、set、toString、有参构造器、EqualsAndHashcode
@NoArgsConstructor      //无参构造器
@Accessors(chain = true)              //链式写法
public class Dept implements Serializable { //所有实体类务必实现序列化，orm 类表关系映射，java类和mysql表相对应

        private Long deptno;            //主键
        private String dname;
        private String db_source;       //这个数据存储在哪个数据库(微服务框架下有很多数据库，同一个信息可能会在不同的数据库)

        public Dept(String dname) {
                this.dname = dname;
        }

        /*
        链式写法：
                Dept dept = new Dept();
                dept.setDeptNo(11).setDname('ssss').setDb_source('DB01');       可以连续set
         */
}
