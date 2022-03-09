package com.piano.score.querytest;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.piano.score.log.domain.RecordException;
import com.piano.score.log.repository.RecordExceptionRepository;

@SpringBootTest
public class QueryTest {
	
	@Autowired
	private RecordExceptionRepository exceptionRepository;
	
	
	@Test
	public void queryTest() {
		RecordException ex =  exceptionRepository.findLastRecordLog();
		System.out.println(ex.toString());
	}
}
