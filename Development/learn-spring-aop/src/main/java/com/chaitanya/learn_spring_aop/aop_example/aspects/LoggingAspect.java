package com.chaitanya.learn_spring_aop.aop_example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before("execution(* com.chaitanya.learn_spring_aop.aop_example.business.*.*(..))")
	public void doSomething(JoinPoint joinPoint) {
		logger.info("Before Method is Called {}",joinPoint);
	}
	
	@Before("execution(* com.chaitanya.learn_spring_aop.aop_example.data.*.*(..))")
	public void doSomeOtherThing(JoinPoint joinPoint) {
		logger.info("Before Method is Called {}",joinPoint);
	}
}
