package com.piano.score.web.convert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Configuration;

import com.piano.score.mvc.repositorydomain.MetaData;
import com.piano.score.mvc.repositorydomain.ScoreList;
import com.piano.score.pagedomain.PageMetaData;
import com.piano.score.pagedomain.PageScoreList;

public class WebDataConvert {

	private JSONParser jsonParser;
	private JSONObject jsonObject;

	public WebDataConvert(String lists) throws ParseException {
		// TODO Auto-generated constructor stub

		this.jsonParser = new JSONParser();
		jsonObject = (JSONObject) jsonParser.parse(lists);
	}

	public MetaData metadataExtract() throws ParseException {
		// TODO Auto-generated method stub

		JSONObject metadata = (JSONObject) jsonObject.get("metadata");

		Map<String, String> map = (Map) metadata.clone();
		return metaDataParser(map);
	}

	public List<ScoreList> dataListExtract() throws ParseException {
		// TODO Auto-generated method stub

		List<ScoreList> scoreMetaDatas = new ArrayList<ScoreList>();

		for (int i = 0; i < jsonObject.size() - 1; i++) {
			JSONObject data = (JSONObject) jsonObject.get(String.valueOf(i));

			Map<String, String> map = (Map) data.clone();

			String id = String.valueOf(map.get("id"));
			String type = String.valueOf(map.get("type"));
			String parent = String.valueOf(map.get("parent"));
			String intvals = String.valueOf(map.get("intvals"));
			String permlink = String.valueOf(map.get("permlink"));

			scoreMetaDatas.add(new ScoreList(id, type, parent, intvals, permlink));

		}
		return scoreMetaDatas;
	}

	public int dataSize() {
		int size = jsonObject.size();
		return size;
	}

	private MetaData metaDataParser(Map<String, String> map) {

		String start = String.valueOf(map.get("start"));
		String limit = String.valueOf(map.get("limit"));
		String sortby = String.valueOf(map.get("sortby"));
		String sortdirection = String.valueOf(map.get("sortdirection"));
		String moreseltsavilable = String.valueOf(map.get("moreresultsavailable"));
		String timestamp = String.valueOf(map.get("timestamp"));
		String apiversion = String.valueOf(map.get("apiversion"));

		return new MetaData(Integer.valueOf(start), Integer.valueOf(limit), sortby, sortdirection,
				Boolean.valueOf(moreseltsavilable), Long.valueOf(timestamp), Integer.valueOf(apiversion));
	}

}
