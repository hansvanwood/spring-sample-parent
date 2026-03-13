package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MovieLogAspect {
    private static final Logger log = LoggerFactory.getLogger(MovieLogAspect.class);

    /**
     * 公共切入点：拦截 MovieController 中所有 public 方法
     */
    @Pointcut("execution(public * com.example.controller.MovieController.*(..))")
    public void movieControllerMethods() {
    }

    // 这个类本身就是一个 Aspect（切面）
    @Around("movieControllerMethods()")
    public Object monitorPerformance(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        long startTime = System.currentTimeMillis();

        log.info("[Around - Before] 方法 [{}] 即将执行", methodName);

        Object result;
        try {
            // 调用目标方法（不调用此行则目标方法不会执行）
            result = pjp.proceed();
            log.info("[Around - AfterReturning] 方法 [{}] 正常返回", methodName);
        } catch (Throwable ex) {
            log.error("[Around - AfterThrowing] 方法 [{}] 抛出异常：{}", methodName, ex.getMessage());
            throw ex; // 必须重新抛出，否则异常被吞掉
        } finally {
            long elapsed = System.currentTimeMillis() - startTime;
            log.info("[Around - After] 方法 [{}] 执行耗时：{} ms", methodName, elapsed);
        }

        return result;
    }
}