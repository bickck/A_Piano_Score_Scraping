package com.piano.score.mvc.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piano.score.mvc.repodomain.page.BaseInformation;
import com.piano.score.mvc.repodomain.page.OutPutDataList;
import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.mvc.repository.MetaDataRepository;
import com.piano.score.mvc.repository.PageDataListRepository;
import com.piano.score.mvc.repository.ScoreRepository;
import com.piano.score.mvc.service.WebDataService;
import com.piano.score.pagedomain.PageData;
import com.piano.score.web.dataprocess.DataExtract;

@Service
public class ScoreSiteConnectImpl implements WebDataService {

	/*
	 * 이 서비스는 저장을 위한 서비스임
	 * 
	 */

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private MetaDataRepository metaDataRepository;

	@Autowired
	private PageDataListRepository dataListRepository;

	@Autowired
	private DataExtract dataExtract;

	@Autowired
	private BaseInfoRepository baseInfoRepository;

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

			return result;
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
	public void allWebDataCollect(int type) throws Exception {
		// TODO Auto-generated method stub
		int start = 0;

		while (true) {
			OutPutDataList pageData = dataExtract.pageDataExtract(type, start);
			scoreRepository.saveAll(pageData.getPageScoreList());
			metaDataRepository.save(pageData.getMetaData());
			dataListRepository.save(pageData);
		}
	}

	public OutPutDataList saveTest(int type) {
		// TODO Auto-generated method stub
		int start = 0;
		OutPutDataList pageData = null;
		try {
			pageData = dataExtract.pageDataExtract(type, start);
			scoreRepository.saveAll(pageData.getPageScoreList());
			metaDataRepository.save(pageData.getMetaData());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataListRepository.save(pageData);
	}
}
