package com.piano.score.mvc.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.piano.score.domain.ScoreListPage;

@Entity
public class PageSection {

	@Id
	private Long id;
	
	//@Column(name ="list")
	//private ScoreListPage listPage;
}
