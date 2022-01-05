package com.piano.score.httpconnection;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.piano.score.domain.ScoreMetaData;

public class IMSLPConnectionImpl implements IMSLPConnect, ConnectionUrl {

	private int startPage = 0;
	private Document document;

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
	public void connecting() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ScoreMetaData getScoreMetaData(int start) {
		// TODO Auto-generated method stub

		return null;
	}

}
