package com.springapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by guoqing on 2016/3/25 0025.
 */
@Aspect
@Component
public class LogIntercept {

    public LogIntercept()
    {
        System.out.println("construct LogIntercept");
    }

    @Pointcut("execution(public * com.springapp.controller..*.*(..))")
    public void recordLog(){}

    @Before("recordLog()")
    public void before() {
        this.printLog("已经记录下操作日志@Before 方法执行前");
    }

    @Around("recordLog()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        this.printLog("已经记录下操作日志@Around 方法执行前");
        pjp.proceed();
        this.printLog("已经记录下操作日志@Around 方法执行后");
    }

    @After("recordLog()")
    public void after() {
        this.printLog("已经记录下操作日志@After 方法执行后");
    }

    private void printLog(String str){
        System.out.println(str);
    }
}
