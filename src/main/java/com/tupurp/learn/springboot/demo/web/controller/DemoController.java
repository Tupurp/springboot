package com.tupurp.learn.springboot.demo.web.controller;

import com.tupurp.learn.springboot.demo.constant.DemoProperties;
import com.tupurp.learn.springboot.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxiaoman
 * @Package com.tupurp.learn.springboot.demo
 * @Description: springboot web测试类，返回json数据
 * @date 2020/5/21 17:58
 */
@RestController
@RequestMapping("/demo")
public class DemoController {


        @RequestMapping("/hello")
        public String index() {
            System.out.println(new DemoProperties().getName());
            return "Hello World";
        }

        @RequestMapping("/user")
        public User user(){
            User user = new User();
            user.setName("张三");
            user.setPassword("pass");

            return user;
        }

}
