# PlayWithSpringBoot

一个学习 SpringBoot & SpringCloud 的 workplace

# Start
> git clone https://github.com/xiaop1ng/PlayWithSpringBoot.git

使用 `Maven` 构建项目，`main` 程序在 `com.xiaoping.App.java`


注：
- jdk 1.8 +
- maven 3.5 +

# Build
> mvn package

`jar` 包输出在 `/target` 目录下


# History
- 升级 springboot 2.1.6.RELEASE

- 添加了 mq 的 starter

- 添加了 redis 的 starter

- memcached

- 添加了 email 的 starter

- 添加了数据库连接池

- 添加了 actuator （系统监控）
> http://127.0.0.1/actuator/health

- 添加了 swagger2 （构建 API 文档工具）

- mysql

- 添加了 Dubbo + ZooKeeper 的依赖

- 添加了聊天室页面（使用 thymeleaf 作为模板引擎，暂时只是作为返回静态页面使用）
> http://127.0.0.1/chat

- add Netty 使用到 Netty 的 WebSocket 功能

- init project, Hello,SpringBoot 程序
> http://127.0.0.1

