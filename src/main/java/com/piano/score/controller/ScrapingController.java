package com.piano.score.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piano.score.domain.ScoreMetaData;
import com.piano.score.manufacturing.ScoreListManufacturing;
import com.piano.score.siteconnect.IMSLPConnect;
import com.piano.score.siteconnect.IMSLPConnectionImpl;
import com.piano.score.webscraping.ArtistScraping;

@Controller
public class ScrapingController {

	@Autowired
	private ArtistScraping artistScraping;

	private IMSLPConnect imslpConnect = new IMSLPConnectionImpl();

	private ScoreListManufacturing listManufacturing = new ScoreListManufacturing();

	@GetMapping("test")
	@ResponseBody
	public String scrapingTest() throws Exception {

		IMSLPConnectionImpl connectionImpl = new IMSLPConnectionImpl();

		String test = connectionImpl.test();

		listManufacturing.setScoreOriginalList(test);

		System.out.println(listManufacturing.scoreMetaDataExtract().toString());
		
		listManufacturing.scoreListExtract();
		return "data";
	}

}
