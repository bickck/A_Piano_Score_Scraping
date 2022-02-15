package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.piano.score.mvc.repositorydomain.MetaData;
import com.piano.score.mvc.repositorydomain.OutPutDataList;
import com.piano.score.mvc.repositorydomain.ScoreList;
import com.piano.score.pagedomain.PageData;

public interface DataExtract {

	OutPutDataList pageDataExtract(int type ,int start) throws Exception;

	Long typeOneWebDataCount();

	Long typeTwoWebDataCount();

}
