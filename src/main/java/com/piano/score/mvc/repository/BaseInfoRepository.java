package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.mvc.repodomain.page.BaseInformation;

public interface BaseInfoRepository extends JpaRepository<BaseInformation, Long> {

	BaseInformation findById(int id);
}
