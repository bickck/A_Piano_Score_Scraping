package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.mvc.repodomain.page.WebPageData;

public interface PageDataListRepository extends JpaRepository<WebPageData, Long> {

	
}
