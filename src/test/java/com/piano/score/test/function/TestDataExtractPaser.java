package com.piano.score.test.function;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.piano.score.mvc.repodomain.page.PageMetaData;
import com.piano.score.mvc.repodomain.page.PageScoreInfos;
import com.piano.score.mvc.serviceImpl.WebDataServiceImpl;
import com.piano.score.web.convert.WebDataConvert;
import com.piano.score.web.imslp.ImslpConnection;
import com.piano.score.web.netconnect.ImslpConnectionRestAPI;

@SpringBootTest
public class TestDataExtractPaser {

	private String testURL = "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=1/retformat=json";

	
	public void test() throws Exception {
		ImslpConnection connect = new ImslpConnectionRestAPI();

		//String result = connect.connectToIMSLP(testURL);

		//JSONParser jsonParser = new JSONParser();
		//JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
		int i = 1;

		//.connect. data = (JSONObject) jsonObject.get(String.valueOf(i));
		//Map<String, String> map = (Map<String, String>) data.clone();

		// System.out.println(map.toString());

		// assertNotNull(result);

		//WebDataConvert dataExtractParser = new WebDataConvert(result);

		//List<ScoreInfoList> lists = dataExtractParser.dataListExtract();

		// assertNotNull(lists);
		// ScoreMetaData metaData = dataExtractParser.metadataExtract();

		// System.out.println(metaData.toString());
		//System.out.println(lists.size());

	}

	@Test
	public void typeDataPageCount() throws Exception {
		

		WebDataServiceImpl connectImpl = new WebDataServiceImpl();

		//System.out.println(connectImpl.count_function(1));
	}
}
