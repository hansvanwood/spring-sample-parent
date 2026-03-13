package com.example.service;

import com.example.dao.MovieDao;
import com.example.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MovieService：定义业务逻辑契约。
 *
 * @Service 是 @Component 的语义化变体，专用于业务逻辑层。
 *
 * 【注入方式说明】
 * 本类演示「构造器注入」：将依赖声明为 final，通过构造器由 Spring 注入。
 * 推荐原因：
 *   1. 依赖在对象创建时立即就绪，避免 NPE（NullPointerException）。
 *   2. 便于单元测试时手动传入 Mock 对象，无需启动容器。
 *   3. final 字段保证不可变性，线程更安全。
 */
@Service
public class MovieService {

    // final 修饰：强制在构造时完成赋值
    private final MovieDao movieDao;

    /**
     * 当类中只有一个构造器时，Spring 4.3+ 会自动推断并注入，
     * @Autowired 可省略，此处保留以显式说明意图。
     */
    @Autowired
    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    public Movie getMovieById(Long id) {
        Movie movie = movieDao.findById(id);
        if (movie == null) {
            throw new IllegalArgumentException("未找到 ID 为 " + id + " 的电影");
        }
        return movie;
    }

    public void addMovie(Movie movie) {
        movieDao.save(movie);
    }
}