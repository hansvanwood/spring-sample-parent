package com.example;


import com.example.config.AppConfig;
import com.example.model.Movie;
import com.example.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 子任务二：验证 AOP 各通知类型的触发效果。
 * 请结合控制台输出，确认通知日志出现在预期位置。
 */
@DisplayName("子任务二：AOP 日志切面验证")
class AopTest {

    private MovieService movieService;

    @BeforeEach
    void setUp() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        movieService = ctx.getBean("movieService", MovieService.class);
    }

    // ─────────────────────────────
    // 测试用例 A：触发前置通知 + 环绕通知
    // ─────────────────────────────

    @Test
    @DisplayName("3-1 正常调用 getAllMovies()，观察 @Before 与 @Around 输出")
    void testNormalExecution() {
        System.out.println("\n========== 测试：正常方法调用 ==========");
        var movies = movieService.getAllMovies();

        // 方法能正常返回，断言非空
        assertNotNull(movies);
        assertFalse(movies.isEmpty(), "电影列表不应为空");

        /*
         * 期望控制台出现：
         *   [前置通知 @Before] 方法即将执行 ...
         *   [环绕通知 @Around] ▶ 开始执行 ...
         *   [环绕通知 @Around] ◀ 执行完毕 ...
         *   [返回通知 @AfterReturning] ...
         *   [后置通知 @After] ...
         */
    }

    // ─────────────────────────────
    // 测试用例 B：触发异常通知
    // ─────────────────────────────

    @Test
    @DisplayName("3-2 查询不存在 ID，触发 @AfterThrowing 异常通知")
    void testExceptionAdvice() {
        System.out.println("\n========== 测试：异常方法调用 ==========");

        assertThrows(IllegalArgumentException.class,
                () -> movieService.getMovieById(999L),
                "应抛出 IllegalArgumentException");

        /*
         * 期望控制台出现：
         *   [前置通知 @Before] ...
         *   [环绕通知 @Around] ▶ 开始执行 ...
         *   [环绕通知 @Around] ✖ 方法异常 ...
         *   [异常通知 @AfterThrowing] 方法抛出异常 ...
         *   [后置通知 @After] ...
         *
         * 注意：@AfterReturning 不会出现（方法未正常返回）
         */
    }

    // ─────────────────────────────
    // 测试用例 C：验证耗时记录
    // ─────────────────────────────

    @Test
    @DisplayName("3-3 调用 addMovie()，验证环绕通知记录入参与返回值")
    void testAroundWithArgs() {
        System.out.println("\n========== 测试：带参数的方法调用 ==========");
        Movie newMovie = new Movie(100L, "2001太空漫游", "斯坦利·库布里克", 1968);

        // 方法返回值为 void，@Around 中 result 应为 null
        assertDoesNotThrow(() -> movieService.addMovie(newMovie));

        /*
         * 期望控制台出现：
         *   [环绕通知 @Around] 入参：[Movie{id=100, title='2001太空漫游', ...}]
         *   [环绕通知 @Around] 返回值：null
         */
    }
}