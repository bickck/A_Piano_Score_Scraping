package com.piano.score.web.dataprocess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Configuration;

import com.piano.score.domain.PageMetaData;
import com.piano.score.domain.PageScoreList;
import com.piano.score.mvc.domain.MetaData;
import com.piano.score.mvc.domain.ScoreInfoList;

public class DataExtractParser {

	private JSONParser jsonParser;
	private JSONObject jsonObject;

	public DataExtractParser(String lists) throws ParseException {
		// TODO Auto-generated constructor stub

		this.jsonParser = new JSONParser();
		jsonObject = (JSONObject) jsonParser.parse(lists);
	}

	public PageMetaData metadataExtract() throws ParseException {
		// TODO Auto-generated method stub

		JSONObject metadata = (JSONObject) jsonObject.get("metadata");

		Map<String, String> map = (Map) metadata.clone();
		return metaDataParser(map);
	}

	public List<PageScoreList> dataListExtract() throws ParseException {
		// TODO Auto-generated method stub

		List<PageScoreList> scoreMetaDatas = new ArrayList<PageScoreList>();

		for (int i = 0; i < jsonObject.size() - 1; i++) {
			JSONObject data = (JSONObject) jsonObject.get(String.valueOf(i));

			Map<String, String> map = (Map) data.clone();

			String id = String.valueOf(map.get("id"));
			String type = String.valueOf(map.get("type"));
			String parent = String.valueOf(map.get("parent"));
			String intvals = String.valueOf(map.get("intvals"));
			String permlink = String.valueOf(map.get("permlink"));

			scoreMetaDatas.add(new PageScoreList(id, type, parent, intvals, permlink));

		}
		return scoreMetaDatas;
	}

	public int dataSize() {
		int size = jsonObject.size();
		return size;
	}

	private PageMetaData metaDataParser(Map<String, String> map) {

		String start = String.valueOf(map.get("start"));
		String limit = String.valueOf(map.get("limit"));
		String sortby = String.valueOf(map.get("sortby"));
		String sortdirection = String.valueOf(map.get("sortdirection"));
		String moreseltsavilable = String.valueOf(map.get("moreresultsavailable"));
		String timestamp = String.valueOf(map.get("timestamp"));
		String apiversion = String.valueOf(map.get("apiversion"));

		return new PageMetaData(Integer.valueOf(start), Integer.valueOf(limit), sortby, sortdirection,
				Boolean.valueOf(moreseltsavilable), Long.valueOf(timestamp), Integer.valueOf(apiversion));
	}

}
