package com.tupurp.learn.springboot.demo;

import com.tupurp.learn.springboot.demo.dao.DemoJdbcTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * 数据源测试
 * 1：springboot 2.3 默认数据源（com.zaxxer.hikari.HikariDataSource）
 * 2：默认支持如下数据源 @see(org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration)
 *    2.1：org.apache.commons.dbcp2.BasicDataSource
 *    2.2：com.zaxxer.hikari.HikariDataSource
 *    2.3：org.apache.tomcat.jdbc.pool.DataSource
 * 3：如果想指定自己的数据源
 *     配置 spring.datasource.type 属性
 *
 * */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoDatabaseTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    private DemoJdbcTemplate demoJdbcTemplate;

    /**
     * 测试默认数据源
     * */
    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 测试前确保配置了数据库连接并且department.sql已被执行
     * 测试系统中存在数据源后，默认的jdbcTemplate
     *
     * */
    @Test
    public void testDefaultJdbcTemplate(){
        System.out.println(demoJdbcTemplate.map());
    }
}
