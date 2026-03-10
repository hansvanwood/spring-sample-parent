package com.example;

import com.example.config.AppConfig;
import com.example.controller.MovieController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App04 {
    public static void main(String[] args) {
        System.out.println("1.com.example.App - main: Spring容器启动");

        // 1. 创建 Spring 容器，并指定配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MovieController bean = context.getBean(MovieController.class);
        bean.print();

        // 4. 关闭容器（触发 @PreDestroy 回调）
        context.close();
    }
}
