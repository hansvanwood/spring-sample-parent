package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring 主配置类，替代传统的 applicationContext.xml。
 *
 * @Configuration  标记此类为配置类，其内部的 @Bean 方法会被 CGLIB 代理，
 *                 确保多次调用时返回同一个 Bean 实例（单例语义）。
 *
 * @ComponentScan  指定 Spring 扫描的基础包路径。
 *                 Spring 会递归扫描 com.example 下所有子包，
 *                 将标注了 @Component、@Service、@Repository 等注解的类
 *                 自动注册为 Bean。
 *
 * @EnableAspectJAutoProxy  开启 AspectJ 自动代理，AOP 功能依赖此注解。
 *                          proxyTargetClass = true 表示使用 CGLIB 子类代理（默认）。
 */
@Configuration
@ComponentScan(basePackages = "com.example")
@EnableAspectJAutoProxy
public class AppConfig {
    // 本配置类无需声明额外的 @Bean 方法
    // 所有 Bean 均通过组件扫描自动注册
}