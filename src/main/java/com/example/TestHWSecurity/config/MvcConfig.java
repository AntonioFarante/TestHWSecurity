package com.example.TestHWSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/note").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/edit").setViewName("edit");
        registry.addViewController("/add").setViewName("add");
        registry.addViewController("/login").setViewName("login");
    }

}