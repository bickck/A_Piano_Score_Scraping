package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.domain.MusicScore;

public interface ScoreRepository extends JpaRepository<MusicScore, Long> {

}
