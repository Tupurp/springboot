package com.tupurp.learn.springboot.web;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* webmvc配置
 * 1：@EnableWebMvc 全面接管 spring mvc 配置 不推荐
* */

//@EnableWebMvc
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 首页视图映射
     * 替代LoginController中的login方法
     * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/index.html").setViewName("/login");
        registry.addViewController("/login.html").setViewName("/login");
    }
}
