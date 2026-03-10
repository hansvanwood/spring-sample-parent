package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:application.properties") //读取resources目录下的properties文件
public class AppConfig {
}
