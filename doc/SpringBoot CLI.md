# SpringBoot CLI

Cli （Command Line Interface）， 一个可以帮助我们快速构建 SpringBoot 应用的命令行工具。


# Quik Start
首先需要下载  http://repo.spring.io/release/org/springframework/boot/spring-boot-cli/

我们这里选择的是 2.0.1.RELEASE 版本
http://repo.spring.io/release/org/springframework/boot/spring-boot-cli/2.0.1.RELEASE/spring-boot-cli-2.0.1.RELEASE-bin.zip

下载完成后解压，然后将解压出来的 `/bin` 目录添加至环境变量中
在 `cmd` 程序中输入 `spring --version` 会输出
> Spring CLI v2.0.1.RELEASE

即表明安装配置成功
然后我们写一段 Java 程序测试一下

- Hello.java
```
@RestController
public class Hello {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Cli";
    }
}
```
将 `cmd` 程序切换至 `Hello.java` 文件所在目录下执行 `spring run Hello.java`
SpringBoot CLI 在这时会构建并启动程序，启动完成后，访问 http://127.0.0.1:8080/hello

> Hello, Cli

到这里我们的测试就已经通过了

# SpringBoot actuator 
SpringBoot actuator 是一个对应用运行状态监视的工具，actuator 为我们提供了很多可以被监视的端点（Endpoints），同时也支持我们自定端点（Endpoint）。

# 先启动 actuator

首先在我们的 SpringBoot 应用中添加上 `actuator` 的依赖

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

相关配置：
- application.yml

```
# info 配置项（/actuator/info）
info:
  author: xiaop1ng
  email: jianchaoping@gmail.com
  version: 1.0.0

# 配置 actuator 加载所有的端点
management:
  endpoints:
    web:
      exposure:
        include: '*'
  endpoint:
    health:
      show-details: always
```

启动 SpringBoot 应用程序后访问路由 `/actuator/info`
```
// http://127.0.0.1:3000/actuator/info

{
  "author": "xiaop1ng",
  "email": "jianchaoping@gmail.com",
  "version": "1.0.0"
}
```

然后接着我们可以试一试其他的端点监控的路由
- `/actuator/autoconfig` 应用的自动化配置报告
-  `/actuator/beans`  应用上下文创建的所有 Bean
-  `/actuator/configprops` 应用中配置的属性信息报告
-  `/actuator/env` 环境属性报告
-  `/actuator/mappings` SpringMVC 的控制器映射关系报告
-  `/actuator/info` 自定义的配置信息
-  `/actuator/metrics` 当前应用的各类重要度量指标
-  `/actuator/health` 应用的各类健康指标信息
-  `/actuator/threaddump` 用来暴露程序运行中的线程信息
-  `/actuator/httptrace` 显示HTTP跟踪信息（默认显示最后100个HTTP请求）
-  `/actuator/scheduledtasks` 计划任务

...


