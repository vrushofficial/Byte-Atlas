package com.bytes.atlas.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
class LoggerConfig {
	public static final Logger logger = LoggerFactory.getLogger(LoggerConfig.class);

	@Before("execution(* com.byte.atlas.*.*.*(..))")
	public void loggingBeforeServices(JoinPoint joinPoint) {
		logger.info("begin executing {} with parameters {}", joinPoint, joinPoint.getArgs());
	}

	@AfterReturning(value = "execution(* com.byte.atlas.*.*.*(..))", returning = "result")
	public void loggingAfterReturningServices(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}

	@After(value = "execution(* com.byte.atlas.*.*.*(..))")
	public void loggingAfterServices(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}
}
