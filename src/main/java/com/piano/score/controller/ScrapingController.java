package com.piano.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.piano.score.httpconnection.IMSLPConnect;
import com.piano.score.httpconnection.IMSLPConnectionImpl;
import com.piano.score.scraping.ArtistScraping;

@Controller
public class ScrapingController {

	@Autowired
	private ArtistScraping artistScraping;

	private IMSLPConnect imslpConnect = new IMSLPConnectionImpl(null);

	@GetMapping("test")
	public String scrapingTest() throws Exception {
		
		
		imslpConnect.connecting();
		return "data";
	}

}
