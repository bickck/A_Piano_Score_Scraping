package com.piano.score.web.scrap;

import org.springframework.beans.factory.annotation.Autowired;

import com.piano.score.mvc.repodomain.page.WebPageData;
import com.piano.score.mvc.repository.ScoreRepository;
import com.piano.score.web.netconnect.ImslpConnect;

/**
 * 
 * 이 문서는 DB 혹은 특정 URL을 통해 IMSLP 사이트에 있는 페이지를 스크랩핑합니다.
 * 
 * 
 * @author DongHyeon Kim
 * @date 0222-03-22
 * 
 */
public class ImslpSiteScraped {

	@Autowired
	private ImslpConnect connect;

	@Autowired
	private ScoreRepository repository;

	public String scraped(WebPageData webPageData) {
		
		String permlink;
		return "";
	}

	private String getPermlinkById(long id) {

		return repository.getById(id).getPermlink();
	}

}
