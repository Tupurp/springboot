package com.tupurp.learn.springboot.demo;

import com.tupurp.learn.springboot.demo.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot 配置文件测试
 *
 * properties的配置会覆盖yml的配置
 *
 * */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoPersonPropertiesTest {

    @Autowired
    Person person;

    @Test
    public void testPersonProperties(){
        System.out.println(person);
    }
}
