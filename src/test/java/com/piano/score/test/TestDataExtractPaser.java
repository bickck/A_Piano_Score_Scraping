package com.piano.score.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.piano.score.mvc.domain.PageMetaData;
import com.piano.score.mvc.domain.PageScoreList;
import com.piano.score.mvc.serviceImpl.ScoreSiteConnectImpl;
import com.piano.score.web.dataprocess.DataExtractParser;
import com.piano.score.web.netconnect.IMSLPConnect;
import com.piano.score.web.netconnect.IMSLPConnectionImpl;

@SpringBootTest
public class TestDataExtractPaser {

	private String testURL = "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=1/retformat=json";

	
	public void test() throws Exception {
		IMSLPConnect connect = new IMSLPConnectionImpl();

		String result = connect.connectToIMSLP(testURL);

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
		int i = 1;

		JSONObject data = (JSONObject) jsonObject.get(String.valueOf(i));

		Map<String, String> map = (Map<String, String>) data.clone();

		// System.out.println(map.toString());

		// assertNotNull(result);

		DataExtractParser dataExtractParser = new DataExtractParser(result);

		List<PageScoreList> lists = dataExtractParser.dataListExtract();

		// assertNotNull(lists);
		// ScoreMetaData metaData = dataExtractParser.metadataExtract();

		// System.out.println(metaData.toString());
		System.out.println(lists.size());

	}

	@Test
	public void typeDataPageCount() throws Exception {
		

		ScoreSiteConnectImpl connectImpl = new ScoreSiteConnectImpl();

		//System.out.println(connectImpl.count_function(1));
	}
}
