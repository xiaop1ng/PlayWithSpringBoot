package com.xiaoping.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.annotation.MapperScan;

@Configuration
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.xiaoping.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.xiaoping"})
public class AppConfig {}