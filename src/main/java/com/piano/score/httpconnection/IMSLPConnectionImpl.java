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

public class IMSLPConnectionImpl implements IMSLPConnect, ConnectionUrl {

	private String testurl = "https://imslp.org/wiki/Category:Beethoven,_Ludwig_van";
	private Document document;
	private String url;

	public IMSLPConnectionImpl(String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
	}

	@Override
	public void urlset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void connecting() throws Exception {
		// TODO Auto-generated method stub
		document = Jsoup.connect(testurl).get();
		Elements elements = document.select(".categorypagelink");
		
		for(Element e : elements) {
			System.out.println(e);
		}

	}

}
