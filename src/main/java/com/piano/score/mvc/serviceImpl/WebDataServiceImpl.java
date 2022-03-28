package com.piano.score.mvc.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piano.score.mvc.repodomain.page.BaseInformation;
import com.piano.score.mvc.repodomain.page.WebPageData;
import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.mvc.repository.MetaDataRepository;
import com.piano.score.mvc.repository.PageDataListRepository;
import com.piano.score.mvc.repository.ScoreRepository;
import com.piano.score.mvc.service.WebDataService;
import com.piano.score.pagedomain.PageData;
import com.piano.score.web.dataprocess.extract.DataExtract;

/**
 *  
 * @author DongHyeon_Kim
 *
 *
 * 이 문서는 개발자의 요청에 따라 IMSLP에서 데이터를 가져오고 DB에 저장하는 역할을 수행합니다.
 * 1. 데이터의 총 갯수를 파악할 수 있는 코드 작성
 * 2. 데이터를 수집 저장하는 코드 작성
 */
@Service
public class WebDataServiceImpl implements WebDataService {


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
	public Long pageTypeDataAllCount(int type) throws Exception {

		Optional<BaseInformation> base = baseInfoRepository.findById((long) 1);
		if (type == 1) {
			if (base.get().getTypeOneCount() == 0) {
				BaseInformation b = base.get();
				Long result = dataExtract.typeOneWebDataCount();

				b.setTypeOneCount(result);
				baseInfoRepository.save(b);

				return result;
			}
		}
		if (type == 2) {
			if (base.get().getTypeTwoCount() == 0) {

				BaseInformation b = base.get();
				Long result = dataExtract.typeTwoWebDataCount();
				b.setTypeTwoCount(result);

				baseInfoRepository.save(b);

				return result;
			}
		}
		return null;
	}

	@Override
	public void allWebDataCollect(int type, int start) throws Exception {
		
		/*
		 * AOP를 사용해서 로그 DB 체크 후 start 데이터를 마지막 값으로 변경
		 */

		while (true) {
			WebPageData pageData = dataExtract.pageDataExtract(type, start);
			scoreRepository.saveAll(pageData.getPageScoreList());
			metaDataRepository.save(pageData.getMetaData());
			dataListRepository.save(pageData);
		}
	}

}
