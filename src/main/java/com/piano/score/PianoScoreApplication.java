package com.piano.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.piano.score.log.domain.RecordException;
import com.piano.score.log.repository.RecordExceptionRepository;
import com.piano.score.mvc.repodomain.page.BaseInformation;
import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.mvc.serviceImpl.WebDataServiceImpl;
import com.piano.score.web.netconnect.ImslpConnectionRestAPI;

/**
 * {@link https://imslp.org/wiki/Main_Page}
 * 
 * 해당 프로젝트는 IMSLP에 있는 클래식 악보를 얻기 위하여 만든것 입니다. 유료인 악보는 없으며 무료로 풀린 악보들만 수집을 합니다.
 * 
 * 기능 계획은 특징 주기마다 IMSLP에 새롭게 올라온 악보를 탐색하여 악보를 탐색하고 저장하는 것이 목표입니다.
 * 
 * 
 * @author DongHyeon Kim
 * @create 2022-01-10
 */

@SpringBootApplication
public class PianoScoreApplication {

	@Autowired
	private RecordExceptionRepository exceptionRepository;

	@Autowired
	private BaseInfoRepository baseInfoRepository;

	@Autowired
	private WebDataServiceImpl connectImpl;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PianoScoreApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {

		try {
			connectImpl.allWebDataCollect(1, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BaseInformation info = new BaseInformation(0, 0, 0);
		RecordException rx = new RecordException((long) 1);
		// baseInfoRepository.save(info);
		// exceptionRepository.save(rx);

	}

}
