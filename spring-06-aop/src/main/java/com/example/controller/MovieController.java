package com.example.controller;


import org.springframework.stereotype.Controller;

import java.util.*;

/**
 * 电影控制器 —— 本教程核心案例类（Target 目标对象）
 */
@Controller
public class MovieController {

    private static final Random RANDOM = new Random();

    /**
     * 模拟随机耗时（50ms ~ 300ms）
     */
    private void randomDelay() {
        try {
            Thread.sleep(50 + RANDOM.nextInt(251));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 查询电影列表（硬编码数据）
     */
    public List<Map<String, Object>> getMovieList() {
        randomDelay();

        List<Map<String, Object>> movies = new ArrayList<>();

        Map<String, Object> movie1 = new HashMap<>();
        movie1.put("id", 1L);
        movie1.put("title", "肖申克的救赎");
        movie1.put("year", 1994);
        movies.add(movie1);

        Map<String, Object> movie2 = new HashMap<>();
        movie2.put("id", 2L);
        movie2.put("title", "星际穿越");
        movie2.put("year", 2014);
        movies.add(movie2);

        return movies;
    }

    /**
     * 根据 ID 查询单个电影信息（硬编码数据）
     */
    public Map<String, Object> getMovieById(Long id) {
        randomDelay();

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("电影 ID 不合法：" + id);
        }
        Map<String, Object> movie = new HashMap<>();
        movie.put("id", id);
        movie.put("title", "肖申克的救赎");
        movie.put("year", 1994);
        movie.put("director", "弗兰克·德拉邦特");
        return movie;
    }
}