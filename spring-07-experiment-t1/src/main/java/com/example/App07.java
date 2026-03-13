package com.example;

import com.example.config.AppConfig;
import com.example.controller.MovieController;
import com.example.model.Movie;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App07 {
    /**
     * Spring框架章节实验 - 子任务1
     * @param args
     */
    public static void main(String[] args) {
        // 以配置类初始化 Spring IoC 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 从容器中按类型获取 MovieController Bean
        MovieController controller = context.getBean(MovieController.class);

        // 调用 MovieController 的 listAllMovies 方法
        controller.listAllMovies();
        Movie movie = controller.findMovieById(1L);
        System.out.println("=== 查询id=1的电影 ===");
        System.out.println(movie);

        // 关闭 Spring IoC 容器
        context.close();
    }
}
