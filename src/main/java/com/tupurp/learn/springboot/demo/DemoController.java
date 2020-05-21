package com.tupurp.learn.springboot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxiaoman
 * @Package com.tupurp.learn.springboot.demo
 * @Description:
 * @date 2020/5/21 17:58
 */
@RestController
public class DemoController {


        @RequestMapping("/hello")
        public String index() {
            return "Hello World";
        }

}
