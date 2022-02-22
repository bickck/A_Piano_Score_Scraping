package com.piano.score.log;

import org.apache.logging.log4j.Marker;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.piano.score.web.dataprocess.WebDataExtract;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class PageDataLog {

	private static final Logger logger = LoggerFactory.getLogger(WebDataExtract.class);

	@Pointcut("execeution(public void com.piano.score.mvc.serviceImpl.ScoreSiteConnecImpl.saveTest(int))")
	private void doDataCount(ProceedingJoinPoint joinPoint) throws Throwable {

	}

	@Pointcut("execeution(* *..webDataCount(..)")
	public void timeCount(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object o = joinPoint.proceed();

		long endTime = System.currentTimeMillis();

		logger.info("time = {}ms", endTime - startTime);

	}

}
