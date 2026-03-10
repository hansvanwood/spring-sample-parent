package com.example;

import com.example.config.AppConfig;
import com.example.controller.MovieController;
import com.example.service.MovieService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App05 {
    public static void main(String[] args) {
        System.out.println("1.com.example.App - main: Spring容器启动");

        // 1. 创建 Spring 容器，并指定配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 单例: 两次获取是同一个对象
        MovieController controller1 = context.getBean(MovieController.class);
        MovieController controller2 = context.getBean(MovieController.class);
        System.out.println("controller1 == controller2: " + (controller1 == controller2));

        // 原型: 每次获取都是新对象
        MovieService service1 = context.getBean(MovieService.class);
        MovieService service2 = context.getBean(MovieService.class);
        System.out.println("service1 == service2: " + (service1 == service2));

        // 4. 关闭容器（触发 @PreDestroy 回调）
        context.close();
    }
}
