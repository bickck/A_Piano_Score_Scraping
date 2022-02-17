package com.piano.score.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class PageDataLog {

	@Pointcut("execeution(public void com.piano.score.mvc.serviceImpl.ScoreSiteConnecImpl.saveTest(int))")
	private void doDataCount(ProceedingJoinPoint joinPoint) throws Throwable {

	}

	@Pointcut("execeution(* * saveTest(..)")
	private void saveTest(ProceedingJoinPoint joinPoint) throws Throwable {

	}

}
