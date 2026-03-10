package com.example.service;

import com.example.dao.MovieDao;
import com.example.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieDao movieDao;           // 负责查电影基本信息

    public Movie getMovieDetail(Long movieId) {
        System.out.println("2.com.example.MovieService - getMovieDetail(): 根据movieId=" + movieId + "调用MovieDao");
        return movieDao.getMovieDetail(movieId);
    }
}
