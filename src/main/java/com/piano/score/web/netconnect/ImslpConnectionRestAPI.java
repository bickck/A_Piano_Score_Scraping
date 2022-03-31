package com.piano.score.web.netconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.piano.score.mvc.repodomain.page.PageMetaData;
import com.piano.score.web.imslp.ImslpConnection;

/**
 * 
 * @author DongHyeon_Kim
 * 
 * 이 문서는 웹에서 데이터를 가져옵니다. 데이터-> JSON -> 페이지 데이터
 * 
 */

@Component
public class ImslpConnectionRestAPI implements ImslpConnection {

	@Autowired
	private ImslpUrlBuilder config;

	public ImslpConnectionRestAPI() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param type 1 : 작가 type : 2 악보, start
	 * @return REST API 데이터
	 */
	@Override
	public String connectSiteGetJson(int type, int start) throws Exception {
		// TODO Auto-generated method stub

		String url = typeCheck(type, start);
		URL link = new URL(url);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(link.openStream(), "UTF-8"));
		String result = bufferedReader.readLine();

		return result;
	}

	/**
	 * @param Imslp에 접속하기 위한 URL패턴
	 * @return URL 페이지의 데이터
	 */
	@Override
	public String connectSiteGetData(String url) throws Exception {
		// TODO Auto-generated method stub
		URL link = new URL(url);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(link.openStream(), "UTF-8"));

		return bufferedReader.readLine();
	}

	private String typeCheck(int type, int start) {
		if (type == 1) {
			return config.defaultURLSetting(type, start);
		}
		if (type == 2) {
			return config.defaultURLSetting(type, start);
		}
		throw new IllegalAccessError("올바른 데이터를 입력해주세요");
	}

}
