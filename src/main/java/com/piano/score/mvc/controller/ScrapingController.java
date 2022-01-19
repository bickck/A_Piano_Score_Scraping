package com.piano.score.mvc.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piano.score.domain.ScoreMetaData;
import com.piano.score.mvc.service.ScoreSiteConnectService;
import com.piano.score.web.dataprocess.DataExtractParser;
import com.piano.score.web.netconnect.IMSLPConnect;
import com.piano.score.web.netconnect.IMSLPConnectionImpl;
import com.piano.score.web.scraping.ArtistScraping;

@Controller
public class ScrapingController {

	
	@Autowired
	private ScoreSiteConnectService siteConnectService;

	
	@GetMapping("/requestAllScoreList")
	public void requestScoreList() throws Exception {
		
		//테스트 먼저
		
		
		
	}

}
