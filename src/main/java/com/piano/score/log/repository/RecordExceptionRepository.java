package com.piano.score.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.piano.score.log.domain.RecordException;

public interface RecordExceptionRepository extends JpaRepository<RecordException, Long> {

	@Query(value = "SELECT * FROM scoreproject.recoredlog ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public RecordException findLastRecordLog();
}
