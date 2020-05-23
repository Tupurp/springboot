
####centos7使用docker
```bash
    yum install docker
    systemctl enable docker
    systemctl start docker

    #防火墙
    service firewalld status
    service firewalld stop
```

####docker镜像常用操作
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

####docker 容器操作

| 操作 | 命令 | 说明 |
| ---- | ---- | ---- |
| 运行 | docker run --name contain-name -d image-name | --name 自定义容器名 -d 后台运行 image-name 指定镜像模板|
| 运行的容器列表 | docker ps | 加上 -a 可以查看所有容器|
| 停止 | docker stop contain-name/contain-id  ||
| 启动 | docker start contain-name/contain-id ||
| 删除 | docker rm contain-id||
| 端口映射 | -p 6379:6379 | -p 主机端口映射到容器端口|
| 容器日志 | docker logs 容器名/容器id ||
| 更多命令  | https://docs.docker.com ||


#### [启动mysql容器](https://hub.docker.com/_/mysql)

``docker run -p 3306:3306 --name mysql5.7 -e MYSQL_ROOT_PASSWORD=pass!0ve -d mysql:5.7``

