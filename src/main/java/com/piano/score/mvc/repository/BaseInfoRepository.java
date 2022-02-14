package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.mvc.repositorydomain.BaseInformation;

public interface BaseInfoRepository extends JpaRepository<BaseInformation, Long> {

}
