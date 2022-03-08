package com.piano.score.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


import com.piano.score.log.domain.RecordException;

public interface RecordExceptionRepository
		extends JpaRepository<RecordException, Long> {

	@Query("SELECT * FROM RECOREDLOG ORDER BY id desc limit 1")
	RecordException findLastRecordLog();
}
