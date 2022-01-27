package com.piano.score.web.dataprocess;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.piano.score.domain.BaseInformation;
import com.piano.score.domain.PageScoreList;
import com.piano.score.domain.ScoreListPage;
import com.piano.score.domain.PageMetaData;
import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.web.netconnect.IMSLPConnect;
import com.piano.score.web.netconnect.IMSLPConnectionImpl;

@Configuration
public class WebDataExtract implements DataExtract {

	@Autowired
	private IMSLPConnect imslpConnect;

	public WebDataExtract() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PageScoreList> dataListExtract(String lists) throws ParseException {
		// TODO Auto-generated method stub
		DataExtractParser dataExtractParser = new DataExtractParser(lists);

		return dataExtractParser.dataListExtract();
	}

	@Override
	public PageMetaData metadataExtract(String lists) throws ParseException {
		// TODO Auto-generated method stub
		DataExtractParser dataExtractParser = new DataExtractParser(lists);

		return dataExtractParser.metadataExtract();
	}

	@Override
	public Long typeOneWebDataCount() {
		// TODO Auto-generated method stub
		Long result = (long) 0;
		try {
			result = webDataCount(1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Long typeTwoWebDataCount() {
		// TODO Auto-generated method stub
		Long result = (long) 0;
		try {
			result = webDataCount(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private Long webDataCount(int type) throws Exception {
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
		System.out.println(end);
		isCheck = true;

		while (isCheck) {

			int mid = (end + start) / 2;

			String url = imslpConnect.typeAndStartUrlSetting(type, mid);
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

		return (long) (((end - 1) * 1000) + endData);
	}
}
