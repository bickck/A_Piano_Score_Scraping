package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.mvc.repositorydomain.OutPutDataList;

public interface PageDataListRepository extends JpaRepository<OutPutDataList, Long> {

	
}
