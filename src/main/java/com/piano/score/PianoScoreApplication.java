package com.piano.score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.piano.score.httpconnection.IMSLPConnectionImpl;
import com.piano.score.scraping.ArtistScraping;

@SpringBootApplication
public class PianoScoreApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PianoScoreApplication.class, args);
	}
}
