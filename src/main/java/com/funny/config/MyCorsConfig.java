package com.funny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class MyCorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        //1.添加CORS配置信息
        CorsConfiguration configuration = new CorsConfiguration();
        //1) 允许的域
        configuration.addAllowedOrigin("http://localhost:8888");
        //2) 是否发送Cookie信息
        configuration.setAllowCredentials(true);
        //3) 允许的请求方式
        configuration.addAllowedMethod("*");
        // 4）允许的头信息
        configuration.addAllowedHeader("*");

        //2.添加映射路径，拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", configuration);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}
