package com.piano.score.mvc.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.piano.score.mvc.repodomain.page.PageMetaData;
import com.piano.score.mvc.service.WebDataService;

@RestController
public class ScrapingController {

	@Autowired
	private WebDataService siteConnectService;

	@GetMapping("/requestAllScoreList")
	public void requestScoreList() throws Exception {

	}

	@GetMapping("/TypeOneDataCount")
	public String requestOneTypeDataCount() throws Exception {
		// long result = siteConnectService.typeOneDataCount();
		// String value = String.format("%,d", result);
		return "개";
	}

	@GetMapping("/TypeTwoDataCount")
	public String requestTwoTypeDataCount() throws Exception {
		// long result = siteConnectService.typeTwoDataCount();
		// String value = String.format("%,d", result);
		return "개";
	}

	@GetMapping("/allWebDataCollect")
	public void allWebDataCollect() throws Exception {
		int type = 1;
		// siteConnectService.allWebDataCollect(type);
	}

}
