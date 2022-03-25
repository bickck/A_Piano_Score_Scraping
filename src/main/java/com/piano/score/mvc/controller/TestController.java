package com.piano.score.mvc.controller;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piano.score.log.record.MeasureTimeLog;
import com.piano.score.web.dataprocess.WebDataExtract;

@RestController
@Import(MeasureTimeLog.class)
public class TestController {

	@Autowired
	private WebDataExtract webDataExtract;

	@GetMapping("/testaop")
	public String aopTest() throws Exception {
		webDataExtract.pageDataExtract(1, 1);
		return "Success";
	}
}
