package com.piano.score.web.scrap;

import org.springframework.beans.factory.annotation.Autowired;

import com.piano.score.mvc.repodomain.page.WebPageData;
import com.piano.score.mvc.repository.ScoreRepository;
import com.piano.score.web.netconnect.ImslpConnection;

/**
 * 
 * @author DongHyeon Kim
 * 
 * 이 문서는 DB 혹은 특정 URL을 통해 IMSLP 사이트에 있는 페이지를 스크랩핑합니다.
 * 1. 어떠한 문서가 있는지 확인 
 * 
 * @date 0222-03-22
 * 
 */
public class ImslpSiteScraped {

	@Autowired
	private ImslpConnection connect;

	@Autowired
	private ScoreRepository repository;

	/**
	 * 
	 * @param
	 */
	public String webScrap(WebPageData webPageData) {

		String permlink = null;
		String result = null;
		try {
			result = connect.connectSiteGetData(permlink);
		} catch (Exception e) {
			// TODO: handle exception
			// 예외 발생시 현 위치 저장 후 다시 실행
		}

		return "";
	}
	
	private boolean isContentEmpty() {
		
		return false;
	}

	private String getPermlinkById(long id) {

		return repository.getById(id).getPermlink();
	}

}
