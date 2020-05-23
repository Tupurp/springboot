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