package com.piano.score.mvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piano.score.domain.Score;
import com.piano.score.domain.ScoreMetaData;
import com.piano.score.mvc.service.ScoreSiteConnectService;
import com.piano.score.web.dataprocess.PageDataExtract;
import com.piano.score.web.netconnect.IMSLPConnect;

@Service
public class ScoreSiteConnectImpl implements ScoreSiteConnectService {

	@Autowired
	private IMSLPConnect connect;

	@Autowired
	private PageDataExtract pageDataExtract;

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		int i = 0;
		boolean isCheck = true;

		while (isCheck) {
			connect.typeAndStartUrlSetting(1, i);
			try {
				String result = connect.connectToIMSLP(null);

				if (connect.moreresultsavailable()) {
					pageDataExtract.setScoreOriginalList(result);
					List<Score> list = pageDataExtract.dataListExtract(result);
				} else {
					isCheck = false;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public int typeDataCount() {
		// TODO Auto-generated method stub

		try {

			ScoreMetaData metaData = pageDataExtract.metadataExtract();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
