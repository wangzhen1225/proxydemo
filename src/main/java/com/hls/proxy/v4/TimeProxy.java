package com.hls.proxy.v4;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Description Spring AOP
 * @Author jackwang
 * @Date 2020-10-21 13:14
 *
 * 接口 :  org.aopalliance.intercept.MethodInterceptor
 * before 实现类 : org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor
 * after 实现类 :  org.springframework.aop.aspectj.AspectJAfterAdvice
 * afterRetuing 实现类 : org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor
 *
 * spring aop 通过 chain的方式将这些 通知方法对应的对象链接起来，类似于过滤器链
 */
@Component
@EnableAspectJAutoProxy
@Aspect
public class TimeProxy {

    @Pointcut("execution(public * com.hls.proxy.Car.move(..))")
    public void exec(){}

    @Before("exec()")
    public void before(){
        System.out.println("before....");
        //throw new RuntimeException();
    }

    @After("exec()")
    public void after(){
        System.out.println("after....");
    }

    @AfterReturning("exec()")
    public void afterReturn(){
        System.out.println("afterReturning....");
    }

    @AfterThrowing("exec()")
    public void afterThrowing(){
        System.out.println("afterThrowing....");
    }

}
