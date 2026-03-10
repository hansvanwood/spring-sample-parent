package com.example.controller;

import com.example.service.MovieService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 三种依赖注入方式：构造器注入、Setter方法注入、字段注入
 * 实际开发中，推荐使用构造器注入
 */
@Controller
public class MovieController {

    //1. 字段注入
//    @Autowired
//    private MovieService movieService;

    //2. 构造器注入
    private  MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //3. Setter方法注入
//    private MovieService movieService;
//    @Autowired
//    public void setMovieService(MovieService movieService) {
//        this.movieService = movieService;
//    }


    public void print() {
        movieService.print();
    }

}
