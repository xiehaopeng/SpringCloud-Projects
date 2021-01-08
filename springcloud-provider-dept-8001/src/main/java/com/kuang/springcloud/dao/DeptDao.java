package com.kuang.springcloud.dao;

import com.kuang.springcloud.pojo.Dept;     //这里的Dept是另外一个模块的，通过pom文件导入了进来
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
