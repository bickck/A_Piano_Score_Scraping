package com.piano.score.log;

import org.aopalliance.intercept.Joinpoint;
import org.apache.logging.log4j.Marker;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.piano.score.mvc.repodomain.page.WebPageData;

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

		logger.info("TimeRecord = {}ms , target = {}", endTime - startTime, joinPoint.getTarget());

		return (Long) returnValue;
	}

	@Around(value = "doGetDataRecord()")
	public WebPageData doDataRecord(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();
		WebPageData returnValue = (WebPageData) joinPoint.proceed();
		long endTime = System.currentTimeMillis();

		/*
		 * 데이터를 파일에 저장할 필요 있음.
		 */

		logger.info("TimeRecord = {} ms, target = {}", endTime - startTime, joinPoint.getSignature());
		logger.info("Recording Score MetaData List = {} ", returnValue.getMetaData().toString());

		return returnValue;
	}
	
	/*
	 * =============================================================================================
	 */

	@Pointcut("execution(* com.piano.score.web.dataprocess..Test(..))")
	public void aopDoTest() {
	}

	@Before(value = "aopDoTest()")
	public void beforTest() {
		logger.info("success before print");
	}
	
	@After(value ="aopDoTest()")
	public void afterTest() {
		logger.info("success after print");
	}
	
	@AfterReturning(value = "aopDoTest()",returning = "")
	public void afterRetruningTest() {
		logger.info("success afterReturningTest print");
	}

	@AfterThrowing(value = "aopDoTest()",throwing = "ex")
	public void throwing(JoinPoint joinPoint, Exception ex) {
		logger.info(" --- throwing --");
		logger.info("JoinPoint Signature"+joinPoint.getSignature());
		logger.info("throwing", ex.fillInStackTrace());
	}

	@Around(value = "aopDoTest()")
	public Long aopDoAroundTest(ProceedingJoinPoint joinpoint) throws Throwable {

		logger.info("target = {}", joinpoint.getSignature());

		Object returnValue = joinpoint.proceed();

		logger.info("returnValue = {}", returnValue);

		return (Long) returnValue;

	}

}
