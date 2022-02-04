package com.piano.score.mvc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class OutPutDataList {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "DATALIST")
	@ManyToOne(fetch = FetchType.LAZY)
	private List<PageScoreList> pageScoreList;

	@Column(name = "METADATA")
	@Embedded
	private PageMetaData metaData;

}
