package com.piano.score.mvc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piano.score.domain.BaseInformation;
import com.piano.score.mvc.domain.PageMetaData;
import com.piano.score.mvc.domain.PageScoreList;
import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.mvc.repository.ScoreRepository;
import com.piano.score.mvc.service.ScoreDataService;
import com.piano.score.web.dataprocess.DataExtract;
import com.piano.score.web.dataprocess.DataExtractParser;
import com.piano.score.web.netconnect.IMSLPConnect;

@Service
public class ScoreSiteConnectImpl implements ScoreDataService {

	/*
	 * 이 서비스는 저장을 위한 서비스임
	 * 
	 */

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private DataExtract dataExtract;

	@Autowired
	private BaseInfoRepository baseInfoRepository;

	@Override
	public void connectTest() throws Exception {
		// TODO Auto-generated method stub
		
		
		// 여기서는 저장만해야 함
		// score.save();

	}

	@Override
	@Transactional
	public Long typeOneDataCount() throws Exception {
		// TODO Auto-generated method stub

		Optional<BaseInformation> base = baseInfoRepository.findById((long) 1);
		if (base.get().getTypeOneCount() == 0) {
			BaseInformation b = base.get();
			Long result = dataExtract.typeOneWebDataCount();

			b.setTypeOneCount(result);
			baseInfoRepository.save(b);
		}

		return (long) base.get().getTypeOneCount();
	}

	@Override
	@Transactional
	public Long typeTwoDataCount() throws Exception {
		// TODO Auto-generated method stub
		Optional<BaseInformation> base = baseInfoRepository.findById((long) 1);
		if (base.get().getTypeTwoCount() == 0) {

			BaseInformation b = base.get();
			Long result = dataExtract.typeTwoWebDataCount();
			b.setTypeTwoCount(result);

			baseInfoRepository.save(b);

			return result;
		}

		return (long) base.get().getTypeTwoCount();
	}

	@Override
	public void allWebDataCollect() {
		// TODO Auto-generated method stub

	}

}
