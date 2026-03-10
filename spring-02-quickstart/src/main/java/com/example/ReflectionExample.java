package com.example;

import java.lang.reflect.Method;

/**
 * Spring框架运用了反射机制来实例化对象，并将对象添加到IoC容器中。
 * 反射（Reflection）是一种强大的工具，可以在运行时动态地创建对象、调用方法和访问属性。具体来说，反射允许我们：
 * 1. 获取类的 Class 对象。
 * 2. 创建类的实例（调用构造器）。
 * 3. 获取类中的方法、属性和构造器。
 * 4. 调用方法和访问属性。
 * 通过反射，我们不需要通过new关键字，就可以创建对象实例，并调用其方法。
 */
public class ReflectionExample {

    public static void main(String[] args) throws Exception {
        // 1. 获取 MovieService 的 Class 对象
        Class<?> clazz = Class.forName("com.example.dao.MovieDao");
        // 或者：Class<?> clazz = MovieService.class;

        // 2. 通过反射创建实例（调用无参构造器）
        Object movieDao = clazz.getDeclaredConstructor().newInstance();

        // 3. 获取 getMovieDetailMethod 方法
        Method getMovieDetailMethod = clazz.getMethod("getMovieDetail", Long.class);//第一个参数是方法名，第二个参数是参数类型

        // 4. 调用方法
        getMovieDetailMethod.invoke(movieDao,1L);//调用 getMovieDetail 方法，并传入参数 1L
    }

}
