package com.piano.score.mvc.controller;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piano.score.log.PageDataLog;
import com.piano.score.web.dataprocess.WebDataExtract;

@RestController
@Import(PageDataLog.class)
public class TestController {

	@Autowired
	private WebDataExtract webDataExtract;

	@GetMapping("/test")
	public String test(@RequestParam int a) {
		String result = "Success";

		long value = webDataExtract.typeOneWebDataCount();

		return String.valueOf(value);
	}

	@GetMapping("/testaop")
	public String aopTest() {

		return "Success";
	}
}
