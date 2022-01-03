package com.piano.score.httpconnection;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class IMSLPConnectionImpl implements ConnectionUrl {

	private String url;

	public IMSLPConnectionImpl(String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
	}

	public void connecting() throws Exception {

		URL url = new URL(this.url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setConnectTimeout(ConnectionUrl.TimeOutSet);
		httpURLConnection.setReadTimeout(ConnectionUrl.TimeOutSet);

		for (Map.Entry<String, List<String>> header : httpURLConnection.getHeaderFields().entrySet()) {
			for (String value : header.getValue()) {
				System.out.println(header.getKey() + " : " + value);
			}
		}

		httpURLConnection.disconnect();
	}
	
	
}
