package com.piano.score.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.piano.score.mvc.repodomain.page.PageUrlList;


public interface ScoreRepository extends JpaRepository<PageUrlList, Long> {

	//@Query("SELECT permlink FROM ScoreRepositry LIMIT 1000")
	//List<String> lists(); 
	
}
