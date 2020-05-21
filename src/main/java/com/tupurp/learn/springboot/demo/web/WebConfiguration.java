package com.tupurp.learn.springboot.demo.web;

import com.tupurp.learn.springboot.demo.web.filter.DemoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web配置
 * 从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件，
 * 被注解的类内部包含有一个或多个被@Bean注解的方法
 * 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
 * 并用于构建bean定义，初始化Spring容器。
 *
 * 注意：@Configuration注解的配置类有如下要求：
 *
 * 1：@Configuration不可以是final类型；
 * 2：@Configuration不可以是匿名类；
 * 3：嵌套的configuration必须是静态类。
 * */
@Configuration
public class WebConfiguration {

    /**
     *
     * Spring 提供了FilterRegistrationBean类，此类提供setOrder方法，可以为filter设置排序值，
     * 让spring在注册web filter之前排序后再依次注册。
    * */
    @Bean
    public FilterRegistrationBean buildFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //设置过滤器
        registrationBean.setFilter(new DemoFilter());
        //设置过滤规则
        registrationBean.addUrlPatterns("/*");
        //设置一些初始化参数
        registrationBean.addInitParameter("name","value");
        registrationBean.setName("webDemoFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
