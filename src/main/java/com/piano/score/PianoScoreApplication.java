package com.piano.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.piano.score.log.domain.RecordException;
import com.piano.score.log.repository.OccurExceptionRepository;
import com.piano.score.mvc.repodomain.page.BaseInformation;
import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.web.netconnect.ImslpConnectionImpl;
import com.piano.score.web.scraping.ArtistScraping;

@SpringBootApplication
public class PianoScoreApplication {

	@Autowired
	private OccurExceptionRepository exceptionRepository;

	@Autowired
	private BaseInfoRepository baseInfoRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PianoScoreApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		BaseInformation baseInformation = baseInfoRepository.findById(1);
		
		if(baseInformation == null) {
			BaseInformation info = new BaseInformation(0,0,0);
			baseInfoRepository.save(info);
		}
			
		
	}

	
}
