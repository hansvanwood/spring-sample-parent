package com.example;

import com.example.config.AppConfig;
import com.example.service.MovieService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03 {
    public static void main(String[] args) {
        System.out.println("1.com.example.App - main: Spring容器启动");

        // 1. 创建 Spring 容器，并指定配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("当前 Spring 容器中总共定义了 " + context.getBeanDefinitionCount() + " 个 Bean ，列表如下：");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println("\t" + i + ": " + beanDefinitionNames[i]);
        }

        // 2. 从容器中获取 Bean（不需要 new！）
        MovieService movieService = context.getBean(MovieService.class);

        // 3.调用 movieService
        movieService.print();


        // 4. 关闭容器（触发 @PreDestroy 回调）
        context.close();
    }
}
