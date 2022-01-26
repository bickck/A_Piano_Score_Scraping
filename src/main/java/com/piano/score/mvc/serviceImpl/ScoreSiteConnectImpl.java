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
import com.piano.score.web.dataprocess.DataExtract;
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

	@Autowired
	private DataExtract dataExtract;

	@Override
	public void connectTest() throws ParseException {
		// TODO Auto-generated method stub
		String url = connect.typeAndStartUrlSetting(1, 1);
		DataExtractParser dataExtractParser = new DataExtractParser(url);

		List<Score> lists = dataExtractParser.dataListExtract();
		

	}

	@Override
	public ScoreListPage connect() {
		// TODO Auto-generated method stub
		int i = 0;
		boolean isCheck = true;

		return null;
	}

	@Override
	public int typeDataPageCount(int type) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;

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

}
