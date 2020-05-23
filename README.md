#springboot

### 一：配置文件读取

+ @Value和@ConfigurationProperties获取值区别
|||@Value|
| :- | :- | :- |

    |  | @ConfigurationProperties  | @Value |
    | ------------- | ------------- | ------------- |
    | 功能  | 批量注入配置文件种的属性 | 一个一个单独制定  |
    | 松散绑定 | 支持  | 不支持  |
    | SpEl  | 不支持  | 支持  |
    | JSR303数据校验 | 支持  | 不支持  |
    
+ `@PropertySource`读取指定配置文件

+ `${}`配置文件占位符
    + 随机数
    ```java
        ${random.value},${random.int},${random.long},
        ${random.int(10)}, ${random.int[10,1024]},
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