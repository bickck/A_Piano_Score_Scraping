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

/**
 * 이 문서는 웹에서 데이터를 가져오는 클래스입니다.
 * 
 * 
 * */

@Component
public class ImslpConnectionImpl implements ImslpConnect {
	
	@Autowired
	private ImslpUrlBuilder config;

	public ImslpConnectionImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String connectWebSite(int type, int start) throws Exception {
		// TODO Auto-generated method stub
		
		String url = config.defaultURLSetting(type, start);
		URL link = new URL(url);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(link.openStream(), "UTF-8"));
		String result = bufferedReader.readLine();

		return result;
	}
	
	@Override
	public String connectWebSite(String url) throws Exception {
		// TODO Auto-generated method stub
		URL link = new URL(url);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(link.openStream(), "UTF-8"));
		
		
		return bufferedReader.readLine();
	}

}
