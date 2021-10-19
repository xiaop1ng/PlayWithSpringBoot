package com.xiaoping;

import com.xiaoping.netty.NettyConfig;
import com.xiaoping.netty.ServerBootStrap;
import io.netty.channel.ChannelFuture;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetSocketAddress;

/**
 * @EnableAutoConfiguration  由 @SpringBootApplication 引入，完成启动配置开启
 */
@SpringBootApplication(exclude = RabbitAutoConfiguration.class)
@EnableCaching
// 开启定时任务
@EnableScheduling
@MapperScan("com.xiaoping.mapper")
public class App implements CommandLineRunner{

    private static final Logger logger = Logger.getLogger(App.class);

    @Autowired
    private ServerBootStrap ws;

    public static void main(String[] args) throws Exception {
    	// SpringApplication 将引导我们的应用，启动 Spring，相应地启动被自动配置的 Tomcat web 服务器。
    	// 我们需要将 App.class 作为参数传递给 run 方法，以此告诉 SpringApplication 谁是主要的 Spring 组件，并传递 args 数组以暴露所有的命令行参数。
        SpringApplication.run(App.class, args);
        logger.info("已启动！");
    }

    // 注意这里的 run 方法是重载自 CommandLineRunner
    @Override
    public void run(String... args) throws Exception {

        logger.info("Netty's ws server is listen: " + NettyConfig.WS_PORT);
        InetSocketAddress address = new InetSocketAddress(NettyConfig.WS_HOST, NettyConfig.WS_PORT);
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
