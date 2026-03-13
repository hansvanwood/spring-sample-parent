package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MovieLogAspect {

    /**
     * 公共切入点：拦截 MovieController 中所有 public 方法
     */
    @Pointcut("execution(public * com.example.controller.MovieController.*(..))")
    public void movieControllerMethods() {
    }

    /**
     * @Around 示例：接口耗时监控（环绕通知最典型用法）
     * ProceedingJoinPoint 是 JoinPoint 的子接口，提供 proceed() 方法
     */
    @Around("movieControllerMethods()")
    public Object monitorPerformance(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        long startTime = System.currentTimeMillis();

        System.out.println("[Around - Before] 方法 [" + methodName + "] 即将执行");

        Object result;
        try {
            // 调用目标方法（不调用此行则目标方法不会执行）
            result = pjp.proceed();
            System.out.println("[Around - AfterReturning] 方法 [" + methodName + "] 正常返回");
        } catch (Throwable ex) {
            System.err.println("[Around - AfterThrowing] 方法 [" + methodName + "] 抛出异常：" + ex.getMessage());
            throw ex; // 必须重新抛出，否则异常被吞掉
        } finally {
            long elapsed = System.currentTimeMillis() - startTime;
            System.out.println("[Around - After] 方法 [" + methodName + "] 执行耗时：" + elapsed + " ms");
        }

        return result;
    }


}