package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.mvc.repodomain.page.PageMetaData;

public interface MetaDataRepository extends JpaRepository<PageMetaData, Long> {

}
