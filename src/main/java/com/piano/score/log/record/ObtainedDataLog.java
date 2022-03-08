package com.piano.score.log.record;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.piano.score.mvc.repodomain.page.WebPageData;

@Aspect
@Component
public class ObtainedDataLog {

	private static final Logger logger = LoggerFactory.getLogger(ObtainedDataLog.class);

	@Pointcut("execution(* com.piano.score.web.dataprocess..*page*(..))")
	public void obtainedDataRecord() {

	}

	@Around(value = "obtainedDataRecord()")
	public void doGetData(ProceedingJoinPoint joinPoint) throws Throwable {
		
		

		//return returnValue;
	}

}
