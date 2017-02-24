package com.thoughtworks;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 23/02/2017
 */

@Component
@Aspect
public class TimeAdviseDefine {
    @Around("execution(* com.thoughtworks.HumanGreeting.sayHello(..))")
    public void monitorAround(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("sayHello start time: " + System.currentTimeMillis());
        pjp.proceed();
        System.out.println("sayHello() stop time: " + System.currentTimeMillis());
    }

    @Before("execution(* com.thoughtworks.HumanGreeting.sayHello(..))")
    public void BeginAdvise() {
        System.out.println("begin to invoke sayHello()");
    }

    @Before("execution(* *.sayHello(..))")
    public void EndAdvise() {
        System.out.println("sayHello() invoked");
    }
}
