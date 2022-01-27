package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.piano.score.domain.MusicScore;
import com.piano.score.domain.ScoreMetaData;

public interface DataExtract {

	ScoreMetaData metadataExtract(String lists) throws ParseException;

	List<MusicScore> dataListExtract(String lists) throws ParseException;

	Long typeOneWebDataCount();
	
	Long typeTwoWebDataCount();
	
	
}
