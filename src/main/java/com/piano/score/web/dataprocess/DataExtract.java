package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.piano.score.domain.PageScoreList;
import com.piano.score.domain.PageMetaData;

public interface DataExtract {

	PageMetaData metadataExtract(String lists) throws ParseException;

	List<PageScoreList> dataListExtract(String lists) throws ParseException;

	Long typeOneWebDataCount();
	
	Long typeTwoWebDataCount();
	
	
}
