package com.tupurp.learn.springboot.demo;

import com.tupurp.learn.springboot.demo.constant.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot 配置文件测试
 *
 * application.properties > application.yaml > xxx.properties
 *
 * */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoPersonPropertiesTest {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext context;

    @Test
    public void testPersonProperties(){
        System.out.println(person);
    }

    @Test
    public void testContainsPerson(){
        System.out.println(context.containsBean("personService"));
        System.out.println(context.containsBean("personServiceBean"));
    }
}
