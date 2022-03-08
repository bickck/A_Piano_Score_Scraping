package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.piano.score.mvc.repodomain.page.PageUrlList;


public interface ScoreRepository extends JpaRepository<PageUrlList, Long> {

	
}
