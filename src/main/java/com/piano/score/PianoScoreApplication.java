package com.piano.score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.piano.score.httpconnection.IMSLPConnectionImpl;

@SpringBootApplication
public class PianoScoreApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PianoScoreApplication.class, args);
		
		IMSLPConnectionImpl httpConnection = new IMSLPConnectionImpl("https://imslp.org/wiki/Main_Page");
		
		//httpConnection.connecting();
	}

}
