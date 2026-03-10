package com.example.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:application.properties") //读取resources目录下的properties文件
public class AppConfig {

    // @Value 注入配置文件中的值（后面章节详细讲解）
    @Value("${spring.custom.item:没有读到配置文件的缺省值}")
    private String customItem;

    @PostConstruct
    public void init() {
        System.out.println("com.example.AppConfig - init: " + customItem);
    }

}
