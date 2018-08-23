# 不同环境的不同配置

在 `resources` 下创建 `application-{profile}.yml` 文件
- application.yml
- application-dev.yml
- application-test.yml
- application-prod.yml

我们在 `application-prod.yml` 中描述

```
server:
  port: 80
```

在 `application.yml` 中描述

```
spring:
	profiles:
		active: prod
```
启动工程之后我们的服务监听端口就变成了 `80` 了

# Spring Cloud

## 微服务

> 微服务是一种架构，其中的大型、复杂的软件应用程序由一个或多个更小的服务组成。每个微服务仅负责完成一项代表一种小业务能力的任务。