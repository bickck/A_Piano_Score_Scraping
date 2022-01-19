package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreListPage;
import com.piano.score.domain.ScoreMetaData;
import com.piano.score.web.netconnect.IMSLPConnect;
import com.piano.score.web.netconnect.IMSLPConnectionImpl;

public class WebDataExtract implements DataExtract {

	private ScoreListPage listPage;

	private IMSLPConnect imslpConnect = new IMSLPConnectionImpl();

	public WebDataExtract() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Score> dataListExtract(String result) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreMetaData metadataExtract() throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	public WebDataExtract(List<Score> lists, ScoreMetaData metaData) {
		// TODO Auto-generated constructor stub
		this.listPage.setScore(lists);
		this.listPage.setMetaData(metaData);
	}

	public int allWebDataCount(int type) {
		int result = 0, i = 0;

		System.out.println("TESTSTART");
		try {
			boolean isCheck = true;
			Long start = System.currentTimeMillis();

			while (isCheck) {
				String url = imslpConnect.typeAndStartUrlSetting(type, i);
				String pageResult = imslpConnect.connectToIMSLP(url);
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(pageResult);

				int pageDataSize = jsonObject.size();

				if (pageDataSize > 100) {
					result += (pageDataSize - 1);
					i += 1000;
				} else {
					if (pageDataSize == 1) {
						isCheck = false;
					}
					result += (pageDataSize - 1);
					isCheck = false;
				}

			}
			Long end = System.currentTimeMillis();

			System.out.println("Time" + " : " + (end - start) / 1000 + "초");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
