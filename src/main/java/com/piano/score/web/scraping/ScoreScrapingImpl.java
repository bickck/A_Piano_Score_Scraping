package com.piano.score.web.scraping;

import org.springframework.beans.factory.annotation.Autowired;

import com.piano.score.web.netconnect.ImslpConnect;

public class ScoreScrapingImpl implements ScoreScraping{

	
	@Autowired
	private ImslpConnect connect;
	
	
	
	public ScoreScrapingImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void scraping() {
		// TODO Auto-generated method stub
		
	}
	
}
