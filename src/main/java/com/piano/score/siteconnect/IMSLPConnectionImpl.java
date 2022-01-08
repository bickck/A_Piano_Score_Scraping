package com.piano.score.siteconnect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.piano.score.domain.ScoreMetaData;

public class IMSLPConnectionImpl implements IMSLPConnect, ConnectionUrl {

	private String url = "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=0/retformat=json";

	public IMSLPConnectionImpl(String url) {
		// TODO Auto-generated constructor stub

	}

	@Override
	public String defaultUrlSetting(Integer type, Integer start) {
		// TODO Auto-generated method stub
		String url = defaultUrl + "sort" + type.toString() + "/type" + start.toString() + "/retformat=json";
		return url;
	}

	@Override
	public JSONObject connecting() throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL(this.url);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

		String result = bufferedReader.readLine();

		System.out.println(result.indexOf("metadata"));

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
		JSONObject metadata = (JSONObject) jsonObject.get("metadata");

		System.out.println(metadata.values());

		return jsonObject;

	}

	@Override
	public ScoreMetaData getScoreMetaData(JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		JSONObject data = (JSONObject) jsonObject.get("metadata");

		if (data.isEmpty()) {
			return new ScoreMetaData();
		}
		Map<String, String> map = (Map) data.clone();

		System.out.println("map :" + map.toString());
		
		return new ScoreMetaData();
	}

}
