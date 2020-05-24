package com.tupurp.learn.springboot.demo.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * mybatis 注解版开发配置
 * */

/**
 * 如果mapper接口很多，可以使用@MapperScan指定扫描包
 * */
@MapperScan(basePackages = "com.tupurp.learn.springboot.demo.mapper")
@org.springframework.context.annotation.Configuration
public class MyBatisAnnotationConfig {

    /**
     * 解决注解版驼峰与数据库下划线的映射
     *
     * */
    @Bean
    public ConfigurationCustomizer  configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);

                //可以继续设置其他，比如缓存之类
            }
        };
    }
}
