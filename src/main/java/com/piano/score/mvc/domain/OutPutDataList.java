package com.piano.score.mvc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class OutPutDataList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "LISTS")
	@OneToMany(mappedBy = "pageId",fetch = FetchType.LAZY)
	private List<ScoreInfoList> pageScoreList;

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="START")
	private MetaData metaData;

	public OutPutDataList() {
		// TODO Auto-generated constructor stub
	}

	public OutPutDataList(List<ScoreInfoList> pageScoreList, MetaData metaData) {
		super();
		this.pageScoreList = pageScoreList;
		this.metaData = metaData;
	}

	public OutPutDataList(Long id, List<ScoreInfoList> pageScoreList, MetaData metaData) {
		super();
		this.id = id;
		this.pageScoreList = pageScoreList;
		this.metaData = metaData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ScoreInfoList> getPageScoreList() {
		return pageScoreList;
	}

	public void setPageScoreList(List<ScoreInfoList> pageScoreList) {
		this.pageScoreList = pageScoreList;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

}
