package com.piano.score.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.assertj.core.api.Assertions;

import com.piano.score.mvc.serviceImpl.ScoreSiteConnectImpl;

public class AopTest {

	AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	Method method;

	@BeforeEach
	public void init() throws NoSuchMethodException {
		method = ScoreSiteConnectImpl.class.getMethod("saveTest1", int.class);
	}

	
	public void aopTest() {
		String expression = "execution(* com.piano.score.mvc.serviceImpl.*..saveTest1(..))";
		pointcut.setExpression(expression);
		assertTrue(pointcut.matches(method, ScoreSiteConnectImpl.class));
	}
	
	@Test
	public void aopTest1() {
		String expression = "execution(* *.*..saveTest1(..))";
		pointcut.setExpression(expression);
		assertTrue(pointcut.matches(method, ScoreSiteConnectImpl.class));
	}
}
