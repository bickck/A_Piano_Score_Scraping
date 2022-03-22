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
import com.piano.score.web.netconnect.ImslpConnectionImpl;

@SpringBootApplication
public class PianoScoreApplication {

	@Autowired
	private RecordExceptionRepository exceptionRepository;

	@Autowired
	private BaseInfoRepository baseInfoRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PianoScoreApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {

		BaseInformation info = new BaseInformation(0, 0, 0);
		RecordException rx = new RecordException((long) 1);
		// baseInfoRepository.save(info);
		// exceptionRepository.save(rx);

	}

}
