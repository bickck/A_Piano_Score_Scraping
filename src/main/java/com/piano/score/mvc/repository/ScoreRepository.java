package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.domain.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

}
