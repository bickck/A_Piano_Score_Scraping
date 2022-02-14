package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.mvc.repositorydomain.ScoreInfoList;

public interface ScoreRepository extends JpaRepository<ScoreInfoList, Long> {

}
