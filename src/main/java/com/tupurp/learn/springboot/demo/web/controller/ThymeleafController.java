package com.tupurp.learn.springboot.demo.web.controller;


import com.tupurp.learn.springboot.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * 视图demo
 *
 * springboot 支持
 * Thymeleaf
 * FreeMarker
 * Velocity
 * Groovy
 * JSP
 *
 * 控制器上添加@RequestMapping注解后，在跳转的页面加载静态资源时，在静态资源的访问路径下自动加上了@RequestMapping的值
 * Spring Boot 默认的处理方式就已经足够了，默认情况下Spring Boot 使用WebMvcAutoConfiguration中配置的各种属性。
 * 建议使用Spring Boot 默认处理方式，需要自己配置的地方可以通过配置文件修改。
 * 但是如果你想完全控制Spring MVC，你可以在@Configuration注解的配置类上增加@EnableWebMvc，
 * 增加该注解以后WebMvcAutoConfiguration中配置就不会生效，你需要自己来配置需要的每一项。
 * 这种情况下的配置方法建议参考WebMvcAutoConfiguration类。
 *
 * Spring Boot默认存放模板页面的路径在src/main/resources/templates
 * Thymeleaf默认的页面文件后缀是.html。
 * 同样静态文件路径为
 * classpath:/static/
 *
 * 在application.properties中可以配置thymeleaf模板解析器属性.就像使用springMVC的JSP解析器配置一样
 * #thymeleaf start
 * spring.thymeleaf.mode=HTML5
 * spring.thymeleaf.encoding=UTF-8
 * spring.thymeleaf.content-type=text/html
 * #开发时关闭缓存,不然没法看到实时页面
 * spring.thymeleaf.cache=false
 * #thymeleaf end
 * 具体参考 org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties这个类,上面的配置实际上就是注入到该类中的属性值.
 *
 * 不要忘记写@Controller注解
 * */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping(value = "/demo" ,method =  RequestMethod.GET)
    public String demo(Model model){
        User user = new User();
        user.setName("张三");
        model.addAttribute("user",user);
        return "thymeleaf/demo";
    }
}
