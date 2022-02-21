package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.piano.score.mvc.repodomain.page.MetaData;
import com.piano.score.mvc.repodomain.page.OutPutDataList;
import com.piano.score.mvc.repodomain.page.ScoreList;
import com.piano.score.pagedomain.PageData;

public interface DataExtract {

	OutPutDataList pageDataExtract(int type ,int start) throws Exception;

	Long typeOneWebDataCount();

	Long typeTwoWebDataCount();

}
