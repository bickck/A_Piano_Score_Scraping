package com.piano.score.mvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreListPage;
import com.piano.score.domain.ScoreMetaData;
import com.piano.score.mvc.repository.ScoreRepository;
import com.piano.score.mvc.service.ScoreSiteConnectService;
import com.piano.score.web.dataprocess.DataExtractParser;
import com.piano.score.web.netconnect.IMSLPConnect;

@Service
public class ScoreSiteConnectImpl implements ScoreSiteConnectService {

	@Autowired
	private IMSLPConnect connect;
	
	@Autowired
	private ScoreRepository repository;

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
	public int dataCount(int type) {
		// TODO Auto-generated method stub

		try {

			// ScoreMetaData metaData = pageDataExtract.metadataExtract();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
