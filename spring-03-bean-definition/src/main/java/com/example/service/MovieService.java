package com.example.service;


import com.example.dao.MovieDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 电影业务逻辑层
 *
 * @Slf4j —— Lombok 注解，自动生成 log 变量（等价于 LoggerFactory.getLogger(...)）
 * @Service —— 告诉 Spring：这是一个 Service 层 Bean，请纳入容器管理
 * @RequiredArgsConstructor —— Lombok 注解，为所有 final 字段生成构造器（实现构造器注入）
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    // ✅ 构造器注入：通过 @RequiredArgsConstructor 自动生成的构造器注入
    // 声明为 final，Spring 容器启动时自动找到 MovieDao 类型的 Bean 注入进来
    private final MovieDao movieDao;

    // @Value 注入配置文件中的值（后面章节详细讲解）
    @Value("${spring.custom.item:没有读到配置文件的缺省值}")
    private String customItem;

    /**
     * 获取电影统计数据（带缓存）
     * 双重检查锁（Double-Checked Locking）保证线程安全
     */
    public void print() {
        long movieCount = movieDao.countAll();
        System.out.println("查询到电影数量=" + movieCount);
        System.out.println("读取配置文件=" + customItem);
    }
}