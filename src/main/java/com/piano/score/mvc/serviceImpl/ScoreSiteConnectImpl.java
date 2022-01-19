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

	BaseInformation baseInformation = baseInfoRepository.getById((long) 1);

	@Override
	public int typeOneAllCount() throws Exception {
		// TODO Auto-generated method stub
		int dbTypeOneData = baseInformation.getTypeOneCount();

		if (dbTypeOneData == 0) {
			int result = count_function(1);
			return 0;
		}
		return dbTypeOneData;
	}

	@Override
	public int typeTwoAllCount() throws Exception {
		// TODO Auto-generated method stub
		int dbTypeTwoData = baseInformation.getTypeTwoCount();
		if (dbTypeTwoData == 0) {
			int result = count_function(2);
			return result;
		}
		return dbTypeTwoData;
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

	private int count_function(int type) throws Exception {
		int result = 0, start = 0, end = 0;
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

		while (isCheck) {
			int middle = (end + start) / 2;

			if (middle == 0) {
			}

		}

		Long EndTime = System.currentTimeMillis();

		return result;
	}

}
