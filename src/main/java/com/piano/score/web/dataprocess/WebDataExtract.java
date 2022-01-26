package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Configuration;

import com.piano.score.domain.BaseInformation;
import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreListPage;
import com.piano.score.domain.ScoreMetaData;
import com.piano.score.web.netconnect.IMSLPConnect;
import com.piano.score.web.netconnect.IMSLPConnectionImpl;

@Configuration
public class WebDataExtract implements DataExtract {

	private IMSLPConnect imslpConnect = new IMSLPConnectionImpl();

	public WebDataExtract() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Score> dataListExtract(String lists) throws ParseException {
		// TODO Auto-generated method stub
		DataExtractParser dataExtractParser = new DataExtractParser(lists);

		return dataExtractParser.dataListExtract();
	}

	@Override
	public ScoreMetaData metadataExtract(String lists) throws ParseException {
		// TODO Auto-generated method stub
		DataExtractParser dataExtractParser = new DataExtractParser(lists);

		return dataExtractParser.metadataExtract();
	}

	@Override
	public int allWebDataCount(int type) {
		int result = 0, i = 0;

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

	private int webAllDataCount(int type) throws Exception {
		int start = 0, end = 0, endData = 0;
		boolean isCheck = true;
		// 탐색 알고리즘

		Long StartTime = System.currentTimeMillis();

		while (isCheck) {

			String url = imslpConnect.typeAndStartUrlSetting(type, end);
			String data = imslpConnect.connectToIMSLP(url);
			DataExtractParser dataExtractParser = new DataExtractParser(data);

			if (dataExtractParser.metadataExtract().isMoreResultAvailable()) {
				end += 10000;
			} else {
				isCheck = false;
			}
		}

		isCheck = true;

		while (isCheck) {

			int mid = (end + start) / 2;

			String url = imslpConnect.typeAndStartUrlSetting(1, mid);
			String data = imslpConnect.connectToIMSLP(url);
			DataExtractParser dataExtractParser = new DataExtractParser(data);

			if (dataExtractParser.dataSize() == 1) {
				end = mid;
			}
			if (dataExtractParser.dataSize() > 1000) {
				start = mid;
			}
			if (dataExtractParser.dataSize() < 1000 && dataExtractParser.dataSize() > 1) {
				end = mid;
				url = imslpConnect.typeAndStartUrlSetting(1, end);
				data = imslpConnect.connectToIMSLP(url);
				dataExtractParser = new DataExtractParser(data);
				endData = dataExtractParser.dataSize();
				isCheck = false;
			}
		}
		Long EndTime = System.currentTimeMillis();

		System.out.println("time : " + (EndTime - StartTime) / 1000 + "초");

		return ((end - 1) * 1000) + endData;
	}

	private int resultTypeData(Long type) throws Exception {
		
		BaseInformation baseInformation = new BaseInformation(0, 0);
		if (type == 1) {
			if (baseInformation.getTypeOneCount() == 0) {
				int result = webAllDataCount(1);
				return result;
			}
			return baseInformation.getTypeOneCount();
		}
		if (type == 2) {
			if (baseInformation.getTypeTwoCount() == 0) {
				int result = webAllDataCount(2);
				return result;
			}
			return baseInformation.getTypeTwoCount();
		}
		return -1;
	}

}
