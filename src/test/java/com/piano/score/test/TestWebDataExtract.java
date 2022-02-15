package com.piano.score.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.piano.score.mvc.repositorydomain.ScoreList;
import com.piano.score.web.convert.WebDataConvert;
import com.piano.score.web.dataprocess.WebDataExtract;
import com.piano.score.web.netconnect.ImslpConnect;
import com.piano.score.web.netconnect.ImslpConnectionImpl;

public class TestWebDataExtract {

	@Test
	public void allWebDataCountTest() {

	}

	public void defaultUrlTest() {
		ImslpConnect connect = new ImslpConnectionImpl();

		//String url = connect.defaultUrlSetting("id", 1, 0);

		// System.out.println("defaultUrlTest : " + url);

	}

	public void typeAndStartUrlSetting() {
		ImslpConnect connect = new ImslpConnectionImpl();

		//String url = connect.typeAndStartUrlSetting(1, 100000);

		// System.out.println("typeAndStartUrlSetting : " + url);

	}

	public void connectTest() throws Exception {
		ImslpConnect connect = new ImslpConnectionImpl();
		//String url = connect.typeAndStartUrlSetting(1, 100000);
		//String test = connect.connectToIMSLP(url);
		// System.out.println(test.length());
		// assertNotNull(test);
		// 148336 148334
	}

	public void jsonMapKeyTest() throws Exception {
		ImslpConnect connect = new ImslpConnectionImpl();
		//String url = connect.typeAndStartUrlSetting(1, 100000);

		Long start = System.currentTimeMillis();
		// String result = connect.connectToIMSLP(url);
		Long end = System.currentTimeMillis();

		System.out.println("Time" + " : " + (end - start) / 1000 + "초");

	}

	public void dataListExtractTest() throws Exception {
		ImslpConnect connect = new ImslpConnectionImpl();
		//String url = connect.typeAndStartUrlSetting(1, 0);
		//String result = connect.connectToIMSLP(url);
		/// DataExtractParser dataExtract = new DataExtractParser();

		// List<Score> lists = dataExtract.dataListExtract(result);

		// System.out.println("lists : " + lists.size());

	}

	public void dataListCount() {
		// ImslpConnect connect = new ImslpConnectionImpl();
		//String url = connect.typeAndStartUrlSetting(1, 0);
		// DataExtractParser dataExtract = new DataExtractParser();

		try {

		//	String result = connect.connectToIMSLP(url);

			// List<Score> lists = dataExtract.dataListExtract(result);
			// System.out.println(lists.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void allWebDataCount() {
		WebDataExtract dataExtract = new WebDataExtract();

		//int size = dataExtract.allWebDataCount(1);
		//System.out.println(size);
	}
}
