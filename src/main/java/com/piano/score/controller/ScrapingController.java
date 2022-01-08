package com.piano.score.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piano.score.domain.ScoreMetaData;
import com.piano.score.scraping.ArtistScraping;
import com.piano.score.siteconnect.IMSLPConnect;
import com.piano.score.siteconnect.IMSLPConnectionImpl;

@Controller
public class ScrapingController {

	@Autowired
	private ArtistScraping artistScraping;

	private IMSLPConnect imslpConnect = new IMSLPConnectionImpl(null);

	@GetMapping("test")
	@ResponseBody
	public String scrapingTest() throws Exception {

		JSONObject jsonObject = imslpConnect.connecting();

		ScoreMetaData meta = imslpConnect.getScoreMetaData(jsonObject);

		
		return "data";
	}

}
