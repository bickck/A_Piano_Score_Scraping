package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.piano.score.domain.PageData;
import com.piano.score.mvc.domain.PageMetaData;
import com.piano.score.mvc.domain.PageScoreList;

public interface DataExtract {

	PageData pageDataExtract(String url);

	Long typeOneWebDataCount();

	Long typeTwoWebDataCount();

}
