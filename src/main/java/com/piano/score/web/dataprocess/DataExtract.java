package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreMetaData;

public interface DataExtract {

	ScoreMetaData metadataExtract(String lists) throws ParseException;

	List<Score> dataListExtract(String lists) throws ParseException;

	public int allWebDataCount(int type);

}
