package com.cy.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP 面向切面编程
 *
 * 检测项目所有的业务层方法的耗时
 */
@Aspect // 将当前类标记为切面类
@Component // 将当前类的创建使用维护交由Spring容器维护
public class TimerAspect {

    // @Around：环绕通知。
    // execution：将当前环绕通知映射到某个切面上（指定连接点）
    // *【返回值，不关注】 com.cy.store.service.impl.*【类，不关注】.*【方法，不关注】(..【参数，不关注】)
    // ProceedingJoinPoint接口表示连接点。可理解为目标方法的对象。
    @Around("execution(* com.cy.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        String targetClass = signature.getDeclaringTypeName();
        String targetMethod = signature.getName();

        // 记录起始时间
        long start = System.currentTimeMillis();
        // 调用目标方法，比如本项目的login
        Object result = pjp.proceed();
        // 记录结束时间
        long end = System.currentTimeMillis();
        // 计算耗时
        String method = result.toString();
        System.err.println(targetClass+" -> " + targetMethod + " 运行时长：" + (end - start) + "ms.");
        // 返回连接点方法的返回值
        return result;
    }
}
