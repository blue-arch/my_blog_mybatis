package com.blue.config;

import com.blue.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Blue
 * @Date: 2021/4/1
 * @Time: 12:40
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器LoginInterceptor（自定义的）
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**")
                .excludePathPatterns("/admin").excludePathPatterns("/admin/login"); // 不包括/admin/login和/admin 用于显示登陆页面和登陆请求

    }
}
