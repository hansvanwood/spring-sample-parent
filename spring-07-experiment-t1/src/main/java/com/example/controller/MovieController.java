package com.example.controller;


import com.example.model.Movie;
import com.example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * MovieController：模拟 Web 控制层的职责，负责接收请求并调用 Service。
 * 本实验中以普通 @Component 标注，不引入 Web 层依赖。
 * <p>
 * 【注入方式说明】
 * 本类演示「Setter 注入」：Spring 在 Bean 实例化后，
 * 通过调用带 @Autowired 的 setter 方法完成依赖注入。
 * 适用场景：依赖为可选项，或需要在运行时动态替换实现。
 */
@Controller
public class MovieController {

    private MovieService movieService;

    /**
     * Setter 注入：Spring 在完成 Bean 实例化后自动调用此方法注入依赖。
     */
    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * 打印所有电影列表至控制台，模拟"响应"动作。
     */
    public void listAllMovies() {
        System.out.println("=== 电影列表 ===");
        List<Movie> movies = movieService.getAllMovies();
        movies.forEach(System.out::println);
    }

    /**
     * 按 ID 查询单部电影。
     *
     * @param id 电影 ID
     */
    public Movie findMovieById(Long id) {
        return movieService.getMovieById(id);
    }

    /**
     * 新增一部电影。
     *
     * @param movie 待新增的电影对象
     */
    public void addMovie(Movie movie) {
        movieService.addMovie(movie);
        System.out.println("电影已添加：" + movie);
    }
}