package com.tupurp.learn.springboot.demo.mapper;

import com.tupurp.learn.springboot.demo.model.Department;
import org.apache.ibatis.annotations.*;

/**
 * mybatis操作数据库接口
 * 注解版
 * */

@Mapper //指定这是一个操作数据库的Mapper
public interface DepartmentMapper {


    /**设置主键*/
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("insert into department (name) values (#{name})")
    int save(Department department);

    @Delete("delete from department where 1 = 1 and id = #{id}")
    int deleteById(Integer id);

    @Update("update department set name = #{name} where 1 = 1 and id = #{id}")
    int update(Department department);

    @Select("select * from department where 1 = 1 and id = #{id}")
    Department getById(Integer id);



}
