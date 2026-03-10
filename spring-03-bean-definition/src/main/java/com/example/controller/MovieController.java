package com.example.controller;

import com.example.service.MovieService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    public void print() {
        movieService.print();
    }

    @PostConstruct
    public void init() {
        System.out.println("com.example.MovieController - init: 可以在这里做一些初始化工作...");
        // 可以在这里建立数据库连接、加载缓存等
    }

    @PreDestroy
    public void destroy() {
        System.out.println("com.example.MovieController - destroy: 可以在这里做一些清理工作...");
        // 可以在这里关闭连接、保存数据等
    }
}
