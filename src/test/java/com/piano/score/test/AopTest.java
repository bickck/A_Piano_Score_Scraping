package com.piano.score.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.assertj.core.api.Assertions;

import com.piano.score.mvc.controller.TestController;
import com.piano.score.mvc.serviceImpl.WebDataServiceImpl;
import com.piano.score.web.dataprocess.WebDataExtract;

public class AopTest {

	AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	Method method;

	@BeforeEach
	public void init() throws NoSuchMethodException {
		method = WebDataExtract.class.getMethod("Test");
	}

	public void aopTest() {
		String expression = "execution(* com.piano.score.mvc.serviceImpl.*..saveTest1(..))";
		pointcut.setExpression(expression);
		assertTrue(pointcut.matches(method, WebDataServiceImpl.class));
	}

	// @Test
	public void aopTest1() {
		String expression = "execution(* *.*..saveTest1(..))";
		pointcut.setExpression(expression);
		assertTrue(pointcut.matches(method, WebDataServiceImpl.class));
	}

	// @Test
	// @DisplayName("AOP-WebDataCountMethod-Test")
	public void aopTest2() {
		String expression = "execution(* com.piano.score.web.dataprocess..*.*(..))";
		pointcut.setExpression(expression);
		assertTrue(pointcut.matches(method, WebDataExtract.class));
	}

	// @Test
	// @DisplayName("AOP-test")
	public void aopTest3() {
		String expression = "execution( * com.piano.score.web..*.type*(..))";
		pointcut.setExpression(expression);
		assertTrue(pointcut.matches(method, WebDataExtract.class));
	}

	//@Test
	//@DisplayName("pageWebExtract")
	public void aopTest4() {
		String expression = "execution(* com.piano.score.web.dataprocess..*pageData*(..))";
		pointcut.setExpression(expression);
		assertFalse(pointcut.matches(method, WebDataExtract.class));

	}

	@Test
	@DisplayName("WebDataExtract-Test()")
	public void aopTest5() {
		String expression = "execution(* com.piano.score.web.dataprocess..Test(..))";
		pointcut.setExpression(expression);
		assertTrue(pointcut.matches(method, WebDataExtract.class));

	}
}
