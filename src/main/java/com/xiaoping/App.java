package com.xiaoping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    
    public static void main(String[] args) throws Exception {
    	// SpringApplication 将引导我们的应用，启动 Spring，相应地启动被自动配置的 Tomcat web 服务器。
    	// 我们需要将 Example.class 作为参数传递给 run 方法，以此告诉 SpringApplication 谁是主要的 Spring 组件，并传递 args 数组以暴露所有的命令行参数。    
        SpringApplication.run(App.class, args);
    }
}
