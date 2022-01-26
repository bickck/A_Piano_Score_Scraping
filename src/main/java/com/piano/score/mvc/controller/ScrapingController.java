package com.piano.score.mvc.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piano.score.domain.ScoreMetaData;
import com.piano.score.mvc.service.ScoreDataService;

@Controller
public class ScrapingController {

	@Autowired
	private ScoreDataService siteConnectService;

	@GetMapping("/requestAllScoreList")
	public void requestScoreList() throws Exception {

	}

}
