package com.piano.score.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piano.score.domain.Score;
import com.piano.score.manufacturing.ScoreListManufacturing;
import com.piano.score.service.ScoreSiteConnectService;
import com.piano.score.siteconnect.IMSLPConnect;

@Service
public class ScoreSiteConnectImpl implements ScoreSiteConnectService {

	@Autowired
	private IMSLPConnect connect;

	@Autowired
	private ScoreListManufacturing listManufacturing;

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		int i = 0;
		boolean isCheck = true;

		while (isCheck) {
			connect.defaultUrlSetting(1, i++);
			try {
				String result = connect.connectToIMSLP();

				if(connect.moreresultsavailable()) {
					listManufacturing.setScoreOriginalList(result);
					List<Score> list = listManufacturing.scoreListExtract();
				}else {
					isCheck = false;
				}
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
