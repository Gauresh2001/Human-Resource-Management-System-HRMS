package com.hrms.logging;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingAspect.class);

    // Log Method Execution
    @Around("execution(* com.hrms.serviceimpl.*.*(..))")
    public Object logMethodExecution(
            ProceedingJoinPoint joinPoint) throws Throwable {

        String className =
                joinPoint.getTarget()
                        .getClass()
                        .getSimpleName();

        String methodName =
                joinPoint.getSignature()
                        .getName();

        logger.info(
                "Method Started : {}.{}()",
                className,
                methodName);

        long startTime =
                System.currentTimeMillis();

        Object result =
                joinPoint.proceed();

        long endTime =
                System.currentTimeMillis();

        logger.info(
                "Method Completed : {}.{}()",
                className,
                methodName);

        logger.info(
                "Execution Time : {} ms",
                (endTime - startTime));

        return result;
    }

    // Log Exceptions
    @AfterThrowing(
            pointcut = "execution(* com.hrms.serviceimpl.*.*(..))",
            throwing = "exception")
    public void logException(
            Exception exception) {

        logger.error(
                "Exception Occurred : {}",
                exception.getMessage());
    }
}
