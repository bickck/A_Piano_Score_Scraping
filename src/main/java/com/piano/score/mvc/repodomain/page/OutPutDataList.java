package com.piano.score.mvc.repodomain.page;

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

import com.piano.score.pagedomain.PageMetaData;
import com.piano.score.pagedomain.PageScoreList;

@Entity
public class OutPutDataList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "LISTS")
	@OneToMany(mappedBy = "pageId", fetch = FetchType.LAZY)
	private List<ScoreList> pageScoreList;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "start")
	private MetaData metaData;

	public OutPutDataList() {
		// TODO Auto-generated constructor stub
	}

	public OutPutDataList(List<ScoreList> pageScoreList, MetaData metaData) {
		super();
		this.pageScoreList = pageScoreList;
		this.metaData = metaData;
	}

	public OutPutDataList(Long id, List<ScoreList> pageScoreList, MetaData metaData) {
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

	public List<ScoreList> getPageScoreList() {
		return pageScoreList;
	}

	public void setPageScoreList(List<ScoreList> pageScoreList) {
		this.pageScoreList = pageScoreList;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

}
