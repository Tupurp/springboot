package com.tupurp.learn.springboot.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * druid数据源设置
 * */
@Configuration
public class DruidConfig {
    /**
     * druid数据源配置绑定
     * */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 配置druid监控
     * 配置一个管理后台的servlet
     * */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet());
        Map<String,String> initParam = new HashMap<>();
        initParam.put("loginUsername","tupurp");
        initParam.put("loginPassword","pass!0ve");
        initParam.put("allow","");//默认允许所有
        bean.setInitParameters(initParam);
        bean.addUrlMappings("/druid/*");
        return bean;

    }
    /**
     * 配置一个监控的filter
     * */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParam = new HashMap<>();
        initParam.put("exclusions","*.js,*.css,*.svg,/druid/*");
        bean.setInitParameters(initParam);
        bean.addUrlPatterns("/druid/*");
        return bean;
    }
}
