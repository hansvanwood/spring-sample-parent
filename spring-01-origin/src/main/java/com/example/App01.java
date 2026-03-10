package com.example;

import com.example.entity.Movie;
import com.example.service.MovieService;

public class App01 {
    public static void main(String[] args) {
        System.out.println("1.com.example.App - main: 程序启动");

        // 手动创建 MovieService 对象
        MovieService movieService = new MovieService();
        // 调用 movieService 获取电影详情数据
        Movie movieDetail = movieService.getMovieDetail(1L);

        System.out.println("4.com.example.App - main: 获取电影详情查询结果\t" + movieDetail.toString());
    }
}
