package com.tupurp.learn.springboot.demo.config;

import com.tupurp.learn.springboot.demo.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 *
 * 1：@Configuration 制定当前类为配置类
 */
@Configuration
public class BeansConfig {

    /**
     * 将当前方法返回的组件放入容器种，组件名为方法名
     * */
    @Bean
    public PersonService personServiceBean(){
        return new PersonService();
    }
}
