# PlayWithSpringBoot

一个学习 SpringBoot & SpringCloud 的 workplace

# Get & Run
> git clone https://github.com/xiaop1ng/PlayWithSpringBoot.git

然后使用 `Maven` 构建项目，`main` 程序在 `com.xiaoping.App.java`

> Run App 的 main 方法即可

注：
- jdk 1.8 +
- maven 3.5 +

# Build
> mvn package
等待几分钟后会在 `/target` 目录下得到一个 `jar` 包


# History

2018-07-06: 添加了 Dubbo + ZooKeeper 的依赖

2018-07-25: 添加了聊天室页面（使用 thymeleaf 作为模板引擎，暂时只是作为返回静态页面使用）
> http://127.0.0.1/chat

2018-07-24: add Netty 使用到 Netty 的 WebSocket 功能

2018-07-23: init project, Hello,SpringBoot 程序
> http://127.0.0.1

