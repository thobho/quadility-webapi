package com.thobho.quadilityr.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import static java.lang.String.format;

@Aspect
@Configuration
public class LoggingAspect {

    private final static Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Around("execution(* com.thobho.quadilityr.api.handlers..*(..))")
    public Object httpTimeProfiling(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        logger.info(format("Request time: %d ms.", endTime - startTime));
        return proceed;
    }
}
