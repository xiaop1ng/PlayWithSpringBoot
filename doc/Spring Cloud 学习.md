
# 简介

Spring Cloud 为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等。
Spring Cloud 是基于 SpringBoot 的。

### Spring Cloud 封装了一系列的 Netflix OSS 组件：
- 分布式版本配置（Spring Cloud Config）
- 服务注册与发现（Netflix Eureka）
- 请求路由（Netflix Zuul）
- 服务间调用（Netflix Feign）
- 负载均衡（Netflix Ribbon）
- 断路器模式（Netflix Hystrix）
- 分布式消息（Spring Cloud Bus）

### 分布式系统中的常见模式
> 例如：配置管理（configuration management），服务发现（service discovery），断路器（circuit breakers），智能路由（ intelligent routing），微代理（micro-proxy），控制总线（control bus），一次性令牌（ one-time tokens），全局锁（global locks），领导选举（leadership election），分布式会话（distributed sessions），集群状态（cluster state）

### Spring Cloud Context
应用程序上下文服务

### Bootstrap 应用程序上下文
使用 `bootstrap.yml` 保持引导程序和主要上下文配置很好的分开

