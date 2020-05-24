#springboot

### 一：配置文件读取

+ @Value和@ConfigurationProperties获取值区别

    |  | @ConfigurationProperties  | @Value |
    | ------------- | ------------- | ------------- |
    | 功能  | 批量注入配置文件种的属性 | 一个一个单独制定  |
    | 松散绑定 | 支持  | 不支持  |
    | SpEl  | 不支持  | 支持  |
    | JSR303数据校验 | 支持  | 不支持  |
    
+ `@PropertySource`读取指定配置文件

+ `${}`配置文件占位符
    + 随机数
    ```text
        ${random.value},${random.int},${random.long},
        ${random.int(10)}, ${random.int[10,1024]}
  ```
+ Profile
    + 多Profile文件
    
        编写多个application-env.properties配置文件
       
    + yml支持多文档块方式
        
        以``---``分割建立多个文档块
    
    + 激活指定profile
     
        1：在配置文件中使用``spring.profiles.active=dev``来激活
        
        2：命令行激活
        
        ```cmd
        java -java xxxx.jar --spring.profiles.active=test  
      ```
      
         3：虚拟机参数
          
         ```cmd
          -Dspring.profiles.active=test 
       ```
      
+ 配置文件加载位置

    springboot 启动会扫描以下位置的`application.properties`,`application.yml`文件作为默认配置文件
    
    ```text
    -- classpath:/
    -- classpath:/config
    -- fileL./
    -- file:./config/
  ```
  
    以上文件时按照优先级`从低到高`的顺序，所有位置的文件都会被加载，高优先级配置会覆盖低优先级配置
    
    我们也可以通过配置`spring.config.location`来改变默认配置
    
### 二：webmvc

### 三：数据库操作    

#### 3.1：数据源

+   引入starter ``spring-boot-starter-jdbc``
+   配置``spring.datasource.xx`` 相关数据库配置
+   默认数据源``com.zaxxer.hikari.HikariDataSource``
+   默认可自动配置数据源   

    ```text
    org.apache.commons.dbcp2.BasicDataSource
    com.zaxxer.hikari.HikariDataSource
    org.apache.tomcat.jdbc.pool.DataSource
    ```
    
+   自定义数据源 
    
    1) ``spring.datasource.type=指定数据源``
    
    2)  配置自定义数据源相关属性，并将配置绑定到数据源
    
    ```java
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

    ```   
    
#### 3.2 mybatis 
+ 引入依赖

```xml
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.3.1</version>
    </dependency>

```   

+ 创建Javabean

+ 注解版开发`com.tupurp.learn.springboot.demo.mapper.DepartmentMapper`,`com.tupurp.learn.springboot.demo.config.MyBatisAnnotationConfig`

+ 配置文件开发