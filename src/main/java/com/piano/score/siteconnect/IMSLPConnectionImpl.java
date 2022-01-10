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
import org.json.simple.parser.ParseException;
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

	private String testLink = "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=0/retformat=json";

	private String link;

	public IMSLPConnectionImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String defaultUrlSetting(Integer type, Integer start) {
		// TODO Auto-generated method stub
		String url = defaultUrl + "sort" + type.toString() + "/type" + start.toString() + "/retformat=json";
		return url;
	}

	@Override
	public String connectToIMSLP() throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL(link);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		String result = bufferedReader.readLine();

		return result;

	}

	public String test() throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL(testLink);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

		String result = bufferedReader.readLine();

		return result;

	}
}
