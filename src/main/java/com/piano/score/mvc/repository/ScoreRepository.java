package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.piano.score.mvc.repositorydomain.ScoreList;


public interface ScoreRepository extends JpaRepository<ScoreList, Long> {

	
}
