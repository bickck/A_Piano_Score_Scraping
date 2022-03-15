package com.piano.score.web.scraping;



import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piano.score.mvc.repository.ScoreRepository;


@Service
public class ArtistScraping implements ScoreScraping {

	
	@Autowired
	private ScoreRepository repository;
	

	public ArtistScraping() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void scraping() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
