package com.piano.score.log;

import org.aopalliance.intercept.Joinpoint;
import org.apache.logging.log4j.Marker;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class PageDataLog {

	private static final Logger logger = LoggerFactory.getLogger(PageDataLog.class);

	// @Around("execution(* com.piano.score.web.dataprocess..*.*(..))")
	public Long timeCount(ProceedingJoinPoint joinPoint) throws Throwable {

		logger.info("Strat Time Count : = {} " + joinPoint.getSignature());

		long startTime = System.currentTimeMillis();

		Object o = joinPoint.proceed();

		long endTime = System.currentTimeMillis();

		logger.info("time = {}ms", endTime - startTime);

		return null;
	}

	@Pointcut("execution( * com.piano.score.mvc.controller..*.*(..))")
	public void aopDoTest() {
	}

	@Around(value = "aopDoTest()")
	public void aopDoAroundTest(ProceedingJoinPoint joinpoint) throws Throwable {

		logger.info("getSignature = {}", joinpoint.getSignature());
		logger.info("getTarget = {}", joinpoint.getTarget());
		logger.info("getArgs = {}", joinpoint.getArgs());
		logger.info("getSourceLocation = {}", joinpoint.getSourceLocation());
		logger.info("getStaticPart = {}", joinpoint.getStaticPart());

		joinpoint.getTarget();
		//Object o = joinpoint.proceed();
		//logger.info("webDataExtract value = {}", o.toString());
	}

}
