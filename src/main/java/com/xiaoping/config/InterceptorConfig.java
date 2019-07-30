package com.xiaoping.config;

import com.xiaoping.interceptor.EmailCodeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置验证码拦截器
        registry.addInterceptor(new EmailCodeInterceptor())
                .addPathPatterns("/api/user/signup");

    }
}
