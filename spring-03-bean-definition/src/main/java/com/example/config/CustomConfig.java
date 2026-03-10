package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * 应用公共配置类
 *
 * @Configuration 告诉 Spring：这个类是一个配置类，
 * 相当于一份 XML 配置文件，Spring 会读取每一个@Bean 注解的方法，将方法名作为 Bean 的名称，返回值作为 Bean 的实例。
 */
@Configuration
public class CustomConfig {

    /**
     * 注册日期格式化工具 Bean
     *
     * @Bean 告诉 Spring：方法的返回值是一个 Bean，请纳入容器管理。
     * Bean 的名称默认是方法名，即 "simpleDateFormat"。
     */
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        // 创建一个统一的日期格式化工具，全项目共用同一种格式
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

}