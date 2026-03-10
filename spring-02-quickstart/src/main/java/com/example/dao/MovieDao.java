package com.example.dao;

import com.example.entity.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
    public Movie getMovieDetail(Long movieId) {
        System.out.println("3.com.example.MovieDao - getMovieDetail(): 根据movieId=" + movieId + "查询数据库中的电影详情");

        Movie movie = new Movie();
        movie.setTitle("流浪地球");
        movie.setDirector("郭帆");
        movie.setActor("吴京");
        return movie;
    }
}
