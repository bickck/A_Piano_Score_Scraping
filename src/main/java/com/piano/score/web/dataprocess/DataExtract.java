package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.piano.score.domain.PageData;
import com.piano.score.mvc.domain.MetaData;
import com.piano.score.mvc.domain.ScoreInfoList;

public interface DataExtract {

	PageData pageDataExtract(String url) throws Exception;

	Long typeOneWebDataCount();

	Long typeTwoWebDataCount();

}
