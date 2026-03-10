package com.example.controller;

import com.example.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * 三种依赖注入方式：构造器注入、Setter方法注入、字段注入
 * 实际开发中，推荐使用构造器注入
 */
@RequiredArgsConstructor
@Controller
public class MovieController2 {

    //构造器注入 - 配合lombok中的@RequiredArgsConstructor注解，能以更简洁的方式实现构造器注入
    //只需声明好所有的需要注入的成员变量，将成员变量声明为final，即可实现构造器注入
    private final MovieService movieService;


    public void print() {
        movieService.print();
    }

}
