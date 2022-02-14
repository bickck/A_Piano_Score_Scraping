package com.piano.score.test;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.mvc.repositorydomain.BaseInformation;

@SpringBootTest
public class TestScoreSiteService {

	@Autowired
	private BaseInfoRepository baseInfoRepository;

	@Test
	public void BaseInfoTest() {
		long l = 1;
		
		//baseInfoRepository.save(new BaseInformation(0,0));
		
		List<BaseInformation> lists = baseInfoRepository.findAll();
		long i = baseInfoRepository.count();
		
		
		System.out.println(lists.size());
		System.out.println(i);
		//baseInformation.toString();

		//System.out.println(baseInformation.toString());
		

	}
}
