package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean {

    @Value("${spring.custom.item}")
    private String appName;

    // 1. 构造函数
    public LifecycleBean() {
        System.out.println("com.example.LifecycleBean - 1. 构造函数执行");
    }

    // 2. 依赖注入后
    @PostConstruct
    public void init() {
        System.out.println("com.example.LifecycleBean - 2. @PostConstruct 执行");
        System.out.println("   此时 appName = " + appName);
    }

    // 3. 销毁前
    @PreDestroy
    public void cleanup() {
        System.out.println("com.example.LifecycleBean - 3. @PreDestroy 执行");
    }
}