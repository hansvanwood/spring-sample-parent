package com.example;

import com.example.config.AppConfig;
import com.example.entity.Movie;
import com.example.service.MovieService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02 {
    public static void main(String[] args) {
        System.out.println("1.com.example.App - main: Spring容器启动");

        // 1. 创建 Spring 容器，并指定配置类
        // MovieService movieService = new MovieService();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. 从容器中获取 Bean（不需要 new！）
        // MovieService movieService = new MovieService();
        MovieService movieService = context.getBean(MovieService.class);
        System.out.println("容器中的 MovieService: " + movieService);

        // 3.调用 movieService 获取电影详情数据
        Movie movieDetail = movieService.getMovieDetail(1L);
        System.out.println("4.com.example.App - main: 获取电影详情查询结果\t" + movieDetail.toString());

        // 4. 关闭容器（触发 @PreDestroy 回调）
        context.close();
    }
}
