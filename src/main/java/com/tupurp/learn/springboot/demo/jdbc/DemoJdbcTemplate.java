package com.tupurp.learn.springboot.demo.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;
/**
*如果容器中有数据源，springBoot会 默认向容器中放一个JdbcTemplate
*
* */
@Repository
public class DemoJdbcTemplate {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public Map<String,Object> map(){

        return jdbcTemplate.queryForMap("select * from department limit 1");
    }
}
