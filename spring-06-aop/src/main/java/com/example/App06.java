package com.example;

import com.example.controller.MovieController;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App06 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(App06.class)
                .web(WebApplicationType.NONE)  // 只是临时测试，这里不启动 Tomcat
                .run(args);

        MovieController controller = context.getBean(MovieController.class);

        controller.getMovieList();
        controller.getMovieById(1L);


        context.close();
    }
}
