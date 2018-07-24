package com.xiaoping;

import com.xiaoping.netty.ServerBootStrap;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.net.InetSocketAddress;
import java.util.Arrays;

@SpringBootApplication
public class App implements CommandLineRunner{

    @Autowired
    private ServerBootStrap ws;
    
    public static void main(String[] args) throws Exception {
    	// SpringApplication 将引导我们的应用，启动 Spring，相应地启动被自动配置的 Tomcat web 服务器。
    	// 我们需要将 Example.class 作为参数传递给 run 方法，以此告诉 SpringApplication 谁是主要的 Spring 组件，并传递 args 数组以暴露所有的命令行参数。    
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.stream(beanNames)
                    .sorted()
                    .forEach(System.out::println);

        };
    }

    @Bean
    public ServerBootStrap serverBootStrap(){
        return new ServerBootStrap();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=======>run invoke");
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9090);
        ChannelFuture future = ws.start(address);

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                ws.destroy();
            }
        });

        future.channel().closeFuture().syncUninterruptibly();

    }
}
