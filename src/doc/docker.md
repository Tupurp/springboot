
#### centos7使用docker
```bash
    yum install docker
    systemctl enable docker
    systemctl start docker

    #防火墙
    service firewalld status
    service firewalld stop
```

#### docker镜像常用操作
```
    #检索镜像 docker hub
    docker search 关键字

    #拉取镜像  tag表示标签，多为软件的版本
    docker pull 镜像名[:tag]

    #查看本地镜像列表
    docker images

    #删除指定的本地镜像
    docker rmi image-id

```

#### docker 容器操作

| 操作 | 命令 | 说明 |
| ---- | ---- | ---- |
| 运行 | docker run --name contain-name -d image-name | --name 自定义容器名 -d 后台运行 image-name 指定镜像模板|
| 运行的容器列表 | docker ps | 加上 -a 可以查看所有容器|
| 停止 | docker stop contain-name/contain-id  ||
| 启动 | docker start contain-name/contain-id ||
| 删除 | docker rm contain-id||
| 端口映射 | -p 6379:6379 | -p 主机端口映射到容器端口|
| 容器日志 | docker logs contain-name/contain-id ||
| 进入容器 | docker exec -it contain-name/contain-id | eg:docker exec -it b771f /bin/bash|
| 更多命令  | https://docs.docker.com ||


#### [启动mysql容器](https://hub.docker.com/_/mysql)

``docker run -p 3306:3306 --name mysql5.7 -e MYSQL_ROOT_PASSWORD=pass!0ve -d mysql:5.7``

+ mysql镜像的默认编码为`latin1`

    1) `show VARIABLES like 'character_set_server'`
    
    2) [修改docker容器MySQL配置文件](https://blog.csdn.net/zhaoyajie1011/article/details/98623666?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1)
      ```text
      #进入容器
      docker exec -it b771f /bin/bash
      
      #查看配置文件
      more /etc/mysql/mysql.conf.d/mysqld.cnf
      
      #退出容器
      exit
      
      #将配置从容器中copy到宿主机（如果没有该配置文件，直接将第三步的配置放到容器中）
      docker cp b771f:/etc/mysql/mysql.conf.d/mysqld.cnf /root/mysqld.cnf

      #将修改后的配置copy到容器  
      docker cp /root/mysqld.cnf b771f:/etc/mysql/mysql.conf.d/
      
      #重启容器
      docker restart b771f 

      ```
    
    
+ 配置内容如下
 
    
        ```text
              # For explanations see
              # http://dev.mysql.com/doc/mysql/en/server-system-variables.html
              
              [mysqld]
              pid-file        = /var/run/mysqld/mysqld.pid
              socket          = /var/run/mysqld/mysqld.sock
              datadir         = /var/lib/mysql
              #log-error      = /var/log/mysql/error.log
              # By default we only accept connections from localhost
              #bind-address   = 127.0.0.1
              # Disabling symbolic-links is recommended to prevent assorted security risks
              symbolic-links=0
              character_set_server=utf8
              init_connect='SET NAMES utf8'
              max_allowed_packet = 20M
              
              [mysql]
              default-character-set = utf8
              
              [mysql.server]
              default-character-set = utf8
              
              [mysqld_safe]
              default-character-set = utf8
              
              [client]
              default-character-set = utf8
        ```

#### [启动zookeeper容器](https://hub.docker.com/_/zookeeper)

+ 下载镜像 ``docker pull zookeeper:3.5``

+ 启动镜像 ``docker run --name zookeeper -p 2181:2181 --restart always -d 6bd990489b09``
    
+ 客户端连接测试 `docker run -it --rm --link zookeeper:zookeeper zookeeper:3.5 zkCli.sh -server zookeeper`  
    
    

