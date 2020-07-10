package com.wxk.cmdb.controller.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/register","/register.html","/pages/register.html").excludePathPatterns("/login","/login.html","/logout").excludePathPatterns("/css/**","/data/**","/images/**","/js/**","/lib/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
