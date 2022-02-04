package com.piano.score.web.netconnect;

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
import org.json.simple.parser.ParseException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.piano.score.mvc.domain.PageMetaData;

@Configuration
public class ImslpConnectionImpl implements ImslpConnect {

	// type = 1은 사람
	// type = 2는 악보

	// private String testLink =
	// "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=0/retformat=json";

	private String result;

	public ImslpConnectionImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String defaultUrlSet(String sort, Integer type, Integer start) {
		// TODO Auto-generated method stub
		String url = defaultUrl + "sort=" + sort + "/type=" + type.toString() + "/start=" + start.toString()
				+ "/retformat=json";
		return url;
	}

	@Override
	public String typeAndStartUrlSet(Integer type, Integer start) {
		// TODO Auto-generated method stub
		String url = typeAndStartUrl + "sort=id/type=" + type.toString() + "/start=" + start.toString()
				+ "/retformat=json";
		return url;
	}

	@Override
	public String connectToIMSLP(String url) throws Exception {
		// TODO Auto-generated method stub

		if (url != null) {
			URL link = new URL(url);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(link.openStream(), "UTF-8"));
			String result = bufferedReader.readLine();
			this.result = result;
		}

		return result;
	}

	@Override
	public boolean moreresultsavailable() throws ParseException {
		// TODO Auto-generated method stub
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

		JSONObject metadata = (JSONObject) jsonObject.get("metadata");
		Map<String, String> map = (Map) metadata.clone();

		return Boolean.valueOf(map.get("moreresultsavailable"));
	}

}
