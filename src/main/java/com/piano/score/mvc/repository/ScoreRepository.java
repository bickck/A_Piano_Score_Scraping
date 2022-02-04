package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.mvc.domain.ScoreInfoList;

public interface ScoreRepository extends JpaRepository<ScoreInfoList, Long> {

}
