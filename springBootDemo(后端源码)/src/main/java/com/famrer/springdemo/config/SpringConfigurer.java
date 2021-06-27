package com.famrer.springdemo.config;

import com.famrer.springdemo.Interceptor.CorsInterceptor;
import com.famrer.springdemo.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringConfigurer implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;
    @Resource
    private CorsInterceptor corsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor).addPathPatterns("/api/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/api/test/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/api/user/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/api/todoList/**");
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/api/todoList/modifyTask");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
//        addCorsMappings(registry);
    }
}
