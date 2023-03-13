package com.wesley.stock.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class TraceAspect {

//    @Before("@annotation(com.wesley.stock.annotation.Trace)")
    @Before("execution(* com.wesley.stock.web..*(..)) || " +
            "execution(* com.wesley.stock.service..*(..)) ||" +
            "execution(* com.wesley.stock.repository..*(..))")
    public void doTrace(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        log.info("[log] {}", joinPoint.getSignature());
    }

}
