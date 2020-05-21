package com.tupurp.learn.springboot.demo.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件测试
 *
 * 1：@Component
 * 2：@Service
 * 3：@Controller
 * 4：@Repository
 * 注解的类，并把这些类纳入进spring容器中管理，（把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）。
 *
 * ConfigurationProperties:https://blog.csdn.net/yusimiao/article/details/97622666
 * 如果使用 SpEL 表达式，我们只能选择 @Value 注解
 * */
@Component
@ConfigurationProperties(prefix = "com.tupurp" ,ignoreUnknownFields= true)
public class DemoProperties {

    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
