package com.dong.review.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * view의 경로를 static이 아닌 templates으로 관리하기 위한 설정
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/")
//                .setCacheControl(CacheControl.maxAge(10, TimeUnit.NANOSECONDS))
        ;
    }
}
