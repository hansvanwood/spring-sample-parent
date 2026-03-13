package com.example;

import com.example.config.AppConfig;
import com.example.controller.MovieController;
import com.example.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 子任务一：验证 IoC 容器是否正确完成 Bean 注册与依赖注入。
 */
@DisplayName("子任务一：IoC 注解驱动配置验证")
class IoCTest {

    private ApplicationContext ctx;
    private MovieController movieController;

    @BeforeEach
    void setUp() {
        // 以配置类初始化 Spring IoC 容器
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // 从容器中按类型获取 MovieController Bean
        movieController = ctx.getBean(MovieController.class);
    }

    @Test
    @DisplayName("1-1 容器能正常获取 MovieController Bean")
    void testBeanNotNull() {
        assertNotNull(movieController, "MovieController Bean 不应为 null");
        System.out.println("✅ MovieController Bean 获取成功：" + movieController);
    }

    @Test
    @DisplayName("1-2 MovieController 能正常列出所有电影（验证 Setter 注入）")
    void testListAllMovies() {
        // listAllMovies() 内部调用 Service → Dao，若注入失败会抛出 NPE
        assertDoesNotThrow(() -> movieController.listAllMovies(),
                "listAllMovies() 不应抛出异常");
    }

    @Test
    @DisplayName("1-3 按 ID 查询已存在的电影")
    void testFindExistingMovie() {
        Movie movie = movieController.findMovieById(1L);
        assertNotNull(movie, "ID=1 的电影应存在");
        System.out.println("✅ 查询到电影：" + movie);
    }

    @Test
    @DisplayName("1-4 查询不存在的电影应抛出 IllegalArgumentException")
    void testFindNonExistingMovie() {
        assertThrows(IllegalArgumentException.class,
                () -> movieController.findMovieById(999L),
                "查询不存在的 ID 应抛出 IllegalArgumentException");
    }
}