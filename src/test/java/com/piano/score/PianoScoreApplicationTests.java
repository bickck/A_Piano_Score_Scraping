package com.piano.score;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PianoScoreApplicationTests {

	@Before
	void before() {
		System.out.println("before");
	}

	@Test
	void contextLoads() {

		System.out.println("Test");
	}

	@After
	void after() {
		System.out.println("after");
	}

}
