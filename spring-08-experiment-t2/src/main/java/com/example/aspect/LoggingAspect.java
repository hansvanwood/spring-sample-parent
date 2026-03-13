package com.example.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志切面类：拦截 com.example.service 包下所有类的所有方法。
 *
 * @Aspect   标记此类为切面类，Spring AOP 会解析其中的通知注解。
 * @Component 将切面本身注册为 Bean，否则 Spring 无法管理它的生命周期。
 *
 * 【重要】@EnableAspectJAutoProxy 已在 AppConfig.java 中声明，
 *         它告知 Spring 为目标 Bean 生成代理对象，使切面生效。
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * 切入点定义：匹配 com.example.service 包（含子包）下
     * 所有类的所有方法，参数不限。
     *
     * 表达式语法：execution([修饰符] 返回类型 [包名.]类名.方法名(参数))
     *   *  → 任意返回类型
     *   .. → service 包及其所有子包
     *   *  → 任意类名
     *   *  → 任意方法名
     *  (..) → 任意参数列表
     */
    @Pointcut("execution(* com.example.service..*.*(..))")
    public void serviceLayer() {
        // 切入点声明方法，方法体为空，仅作为标识符使用
    }

    // ─────────────────────────────────────────────
    // 通知类型一：@Before 前置通知
    // 在目标方法执行「之前」触发，无法阻止方法执行（除非抛异常）
    // ─────────────────────────────────────────────

    /**
     * @param joinPoint 连接点对象，可获取目标方法的签名、参数等信息
     */
    @Before("serviceLayer()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        System.out.println("──────────────────────────────────────────");
        System.out.println("[前置通知 @Before] 方法即将执行：" + methodName);
        System.out.println("[前置通知 @Before] 入参列表：" + Arrays.toString(args));
    }

    // ─────────────────────────────────────────────
    // 通知类型二：@Around 环绕通知
    // 最强大的通知类型：可在方法执行前后插入逻辑，
    // 必须手动调用 proceed() 以执行目标方法。
    // ─────────────────────────────────────────────

    /**
     * 环绕通知：记录方法名称、入参、执行耗时与返回值。
     *
     * @param pjp ProceedingJoinPoint，环绕通知专用，提供 proceed() 方法
     * @return 目标方法的原始返回值（原样透传，不修改）
     * @throws Throwable 目标方法抛出的任何异常都向上传播
     */
    @Around("serviceLayer()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().toShortString();
        Object[] args = pjp.getArgs();

        System.out.println("[环绕通知 @Around] ▶ 开始执行：" + methodName);
        System.out.println("[环绕通知 @Around] 入参：" + Arrays.toString(args));

        long startTime = System.currentTimeMillis();
        Object result;

        try {
            // 调用目标方法（若注释此行，目标方法将不会执行！）
            result = pjp.proceed();
        } catch (Throwable ex) {
            // 异常在此处被捕获后必须重新抛出，否则会吞掉异常
            System.out.println("[环绕通知 @Around] ✖ 方法异常：" + ex.getMessage());
            throw ex;
        }

        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("[环绕通知 @Around] ◀ 执行完毕：" + methodName
                + " | 耗时：" + elapsed + " ms | 返回值：" + result);
        return result;
    }

    // ─────────────────────────────────────────────
    // 通知类型三：@AfterReturning 返回通知
    // 在目标方法正常返回「之后」触发，可获取返回值
    // ─────────────────────────────────────────────

    /**
     * @param returnValue 目标方法的实际返回值（通过 returning 属性绑定）
     */
    @AfterReturning(pointcut = "serviceLayer()", returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {
        System.out.println("[返回通知 @AfterReturning] 方法正常返回："
                + joinPoint.getSignature().getName()
                + " → " + returnValue);
    }

    // ─────────────────────────────────────────────
    // 通知类型四：@AfterThrowing 异常通知
    // 仅在目标方法抛出异常时触发，可获取异常对象
    // ─────────────────────────────────────────────

    /**
     * @param ex 目标方法抛出的异常（通过 throwing 属性绑定）
     */
    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("[异常通知 @AfterThrowing] 方法抛出异常："
                + joinPoint.getSignature().getName()
                + " | 异常类型：" + ex.getClass().getSimpleName()
                + " | 消息：" + ex.getMessage());
    }

    // ─────────────────────────────────────────────
    // 通知类型五：@After 后置通知（Finally 通知）
    // 无论方法正常返回还是抛出异常，都会触发（类似 finally 块）
    // ─────────────────────────────────────────────

    @After("serviceLayer()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[后置通知 @After] 方法执行结束（无论成功或异常）："
                + joinPoint.getSignature().getName());
        System.out.println("──────────────────────────────────────────");
    }
}