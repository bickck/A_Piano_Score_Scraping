package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreListPage;
import com.piano.score.domain.ScoreMetaData;
import com.piano.score.web.netconnect.IMSLPConnect;
import com.piano.score.web.netconnect.IMSLPConnectionImpl;

public class WebDataExtract {

	private ScoreListPage listPage;

	private IMSLPConnect imslpConnect = new IMSLPConnectionImpl();
	
	private PageDataExtract dataExtract = new PageDataExtract();

	public WebDataExtract(List<Score> lists, ScoreMetaData metaData) {
		// TODO Auto-generated constructor stub
		this.listPage.setScore(lists);
		this.listPage.setMetaData(metaData);
	}

	public int allWebDataCount(int type) {
		String url = imslpConnect.typeAndStartUrlSetting(type, 0);
		int result = 0;
		int i = 0, t = 10000;
		try {
			String pageResult = imslpConnect.connectToIMSLP(url);

			while (true) {
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(pageResult);
				JSONObject metadata = (JSONObject) jsonObject.get("metadata");

				boolean moreresult = Boolean.valueOf(String.valueOf(metadata.get("moreresultsavailable")));

				if (moreresult == true) {
					// start 넘버를 + 해줘야함.
					url = imslpConnect.typeAndStartUrlSetting(type, i);
					pageResult = imslpConnect.connectToIMSLP(url);
					i = i + t;
				} else {
					// 페이지 데이터 확인 meta 데이터만 있을 경우는 안됌
					// 메타데이터와 데이터가 1000개 미만인경우에 멈춰야함.
					t /= 2;
					url = imslpConnect.typeAndStartUrlSetting(type, i - t);
					pageResult = imslpConnect.connectToIMSLP(url);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
