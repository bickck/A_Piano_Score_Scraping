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

import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreMetaData;

@Configuration
public class PageDataExtract implements DataExtract {

	private String scoreOriginalList;

	public PageDataExtract() {
		// TODO Auto-generated constructor stub
	}

	public PageDataExtract(String list) {
		// TODO Auto-generated constructor stub
		this.scoreOriginalList = list;
	}

	public void setScoreOriginalList(String list) {
		this.scoreOriginalList = list;
	}

	@Override
	public ScoreMetaData metadataExtract() throws ParseException {
		// TODO Auto-generated method stub
		JSONObject metadata = (JSONObject) parser().get("metadata");

		Map<String, String> map = (Map) metadata.clone();

		return metaDataParser(map);
	}

	@Override
	public List<Score> dataListExtract() throws ParseException {
		// TODO Auto-generated method stub

		JSONObject json = (JSONObject) parser().get("0");
		List<Score> scoreMetaDatas = new ArrayList<Score>();

		for (int i = 0; i < 1000; i++) {
			json = (JSONObject) parser().get(String.valueOf(i));
			Map<String, String> map = (Map) json.clone();

			String id = String.valueOf(map.get("id"));
			String type = String.valueOf(map.get("type"));
			String parent = String.valueOf(map.get("parent"));
			String intvals = String.valueOf(map.get("intvals"));
			String permlink = String.valueOf(map.get("permlink"));

			scoreMetaDatas.add(new Score(Long.valueOf(i), id, type, parent, intvals, permlink));
		}

		return scoreMetaDatas;
	}

	private ScoreMetaData metaDataParser(Map<String, String> map) {

		String start = String.valueOf(map.get("start"));
		String limit = String.valueOf(map.get("limit"));
		String sortby = String.valueOf(map.get("sortby"));
		String sortdirection = String.valueOf(map.get("sortdirection"));
		String moreseltsavilable = String.valueOf(map.get("moreresultsavailable"));
		String timestamp = String.valueOf(map.get("timestamp"));
		String apiversion = String.valueOf(map.get("apiversion"));

		return new ScoreMetaData(Integer.valueOf(start), Integer.valueOf(limit), sortby, sortdirection,
				Boolean.valueOf(moreseltsavilable), Long.valueOf(timestamp), Integer.valueOf(apiversion));
	}

	private JSONObject parser() throws ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(scoreOriginalList);
		return jsonObject;
	}

}
