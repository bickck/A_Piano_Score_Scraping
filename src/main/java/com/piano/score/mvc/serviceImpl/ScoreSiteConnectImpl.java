package com.piano.score.mvc.serviceImpl;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piano.score.domain.BaseInformation;
import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreListPage;
import com.piano.score.domain.ScoreMetaData;
import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.mvc.repository.ScoreRepository;
import com.piano.score.mvc.service.ScoreDataService;
import com.piano.score.web.dataprocess.DataExtractParser;
import com.piano.score.web.netconnect.IMSLPConnect;

@Service
public class ScoreSiteConnectImpl implements ScoreDataService {

	@Autowired
	private IMSLPConnect connect;

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private BaseInfoRepository baseInfoRepository;

	@Override
	public ScoreListPage connect() {
		// TODO Auto-generated method stub
		int i = 0;
		boolean isCheck = true;

		while (isCheck) {
			String url = connect.typeAndStartUrlSetting(1, i);
			try {

				String result = connect.connectToIMSLP(url);

				if (connect.moreresultsavailable()) {
					// pageDataExtract.setScoreOriginalList(result);
					// List<Score> list = pageDataExtract.dataListExtract(result);
				} else {
					isCheck = false;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int typeDataPageCount(int type) throws Exception {
		// TODO Auto-generated method stub
		int result = typeReturn((long) type);

		return result;
	}

	@Override
	public Score findScoreList(String reqScoreName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Score> lists() {
		// TODO Auto-generated method stub
		return null;
	}

	private int typeReturn(Long type) throws Exception {
		BaseInformation baseInformation = baseInfoRepository.getById(type);
		if (type == 1) {
			if (baseInformation.getTypeOneCount() == 0) {
				int result = count_function(1);
				return result;
			}
			return baseInformation.getTypeOneCount();
		}
		if (type == 2) {
			if (baseInformation.getTypeTwoCount() == 0) {
				int result = count_function(2);
				return result;
			}
			return baseInformation.getTypeTwoCount();
		}
		return -1;
	}

	private int count_function(int type) throws Exception {
		int start = 0, end = 0, endData = 0;
		boolean isCheck = true;
		// 탐색 알고리즘

		Long StartTime = System.currentTimeMillis();

		while (isCheck) {

			String url = connect.typeAndStartUrlSetting(1, end);
			String data = connect.connectToIMSLP(url);
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
			String url = connect.typeAndStartUrlSetting(1, end);
			String data = connect.connectToIMSLP(url);
			DataExtractParser dataExtractParser = new DataExtractParser(data);
			if (dataExtractParser.dataSize() == 1) {
				end = mid;
			} else if (dataExtractParser.dataSize() > 1000) {
				start = mid;
			} else {
				end = mid;
				url = connect.typeAndStartUrlSetting(1, end);
				data = connect.connectToIMSLP(url);
				dataExtractParser = new DataExtractParser(data);
				endData = dataExtractParser.dataSize();
				isCheck = false;
			}
		}
		Long EndTime = System.currentTimeMillis();

		return ((end - 1) * 1000) + endData;
	}

}
