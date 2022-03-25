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

@Entity
public class WebPageData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "LISTS")
	@OneToMany(mappedBy = "pageId", fetch = FetchType.LAZY)
	private List<PageScoreInfos> pageScoreList;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "start")
	private PageMetaData metaData;

	public WebPageData() {
		// TODO Auto-generated constructor stub
	}

	public WebPageData(List<PageScoreInfos> pageScoreList, PageMetaData metaData) {
		super();
		this.pageScoreList = pageScoreList;
		this.metaData = metaData;
	}

	public WebPageData(Long id, List<PageScoreInfos> pageScoreList, PageMetaData metaData) {
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

	public List<PageScoreInfos> getPageScoreList() {
		return pageScoreList;
	}

	public void setPageScoreList(List<PageScoreInfos> pageScoreList) {
		this.pageScoreList = pageScoreList;
	}

	public PageMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(PageMetaData metaData) {
		this.metaData = metaData;
	}

}
