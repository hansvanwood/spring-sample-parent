package com.example.dao;

import com.example.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MovieDao 接口：定义数据访问契约。
 *
 * @Repository 是 @Component 的语义化变体，专用于数据访问层。
 * Spring 会将其注册为名称为 "movieDao" 的 Bean。
 * 在实际项目中，此处通常对应数据库操作；
 * 本实验使用内存集合模拟，以聚焦 Spring 注解本身。
 */
@Repository
public class MovieDao {

    // 用 ConcurrentHashMap 模拟数据库表
    private final Map<Long, Movie> store = new ConcurrentHashMap<>();

    public MovieDao() {
        // 初始化两条测试数据
        store.put(1L, new Movie(1L, "我不是药神", "徐峥", 2018));
        store.put(2L, new Movie(2L, "阿甘正传", "罗伯特·泽米吉斯", 1994));
    }

    public List<Movie> findAll() {
        return new ArrayList<>(store.values());
    }

    public Movie findById(Long id) {
        return store.get(id);
    }

    public void save(Movie movie) {
        store.put(movie.getId(), movie);
    }
}