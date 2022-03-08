package com.piano.score.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.log.domain.RecordException;

public interface ExceptionRecordRepository extends JpaRepository<RecordException,Long >{

}
