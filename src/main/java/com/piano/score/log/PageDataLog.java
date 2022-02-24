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

import com.piano.score.mvc.repodomain.page.OutPutDataList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class PageDataLog {

	private static final Logger logger = LoggerFactory.getLogger(PageDataLog.class);

	@Pointcut("execution( * com.piano.score.web.dataprocess..*.type*(..))")
	public void doTimeRecord() {
	}

	@Pointcut("execution(* com.piano.score.web.dataprocess..*page*(..))")
	public void doGetDataRecord() {

	}

	@Around("doTimeRecord()")
	public Long timeRecord(ProceedingJoinPoint joinPoint) throws Throwable {

		logger.info("Strat Time Recording = {} " + joinPoint.getSignature());

		long startTime = System.currentTimeMillis();
		Object returnValue = joinPoint.proceed();
		long endTime = System.currentTimeMillis();

		logger.info("TimeRecord = {}ms", endTime - startTime);

		return (Long) returnValue;
	}

	@Around(value = "doGetDataRecord()")
	public OutPutDataList doDataRecord(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();
		OutPutDataList returnValue = (OutPutDataList) joinPoint.proceed();
		long endTime = System.currentTimeMillis();

		logger.info("TimeRecord = {}ms", endTime - startTime);
		logger.info("Record Score Data List = {} ", returnValue.getMetaData().toString());

		return returnValue;
	}

	// @Around(value = "aopDoTest()")
	public Long aopDoAroundTest(ProceedingJoinPoint joinpoint) throws Throwable {

		logger.info("target = {}", joinpoint.getSignature());

		Object returnValue = joinpoint.proceed();

		logger.info("returnValue = {}", returnValue);

		return (Long) returnValue;

	}

}
