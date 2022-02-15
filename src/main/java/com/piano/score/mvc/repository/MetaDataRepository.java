package com.piano.score.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piano.score.mvc.repositorydomain.MetaData;

public interface MetaDataRepository extends JpaRepository<MetaData, Long> {

}
