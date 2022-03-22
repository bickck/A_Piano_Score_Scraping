package com.piano.score.web.netconnect;

import org.springframework.stereotype.Component;

/**
 * 이 문서는 URL에 데이터를 요청 가능한 형태로 url을 만들어줍니다.
 * 
 * @author DongHyeon Kim
 * @date 0222-03-22
 * 
 */

@Component
public class ImslpUrlBuilder {

	// private String defaultURL =
	// "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/";
	// private String mainURL =
	// "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=1/retformat=json";
	// private String typeAndStartURL =
	// "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/";

	/*
	 * private String url;
	 * 
	 * private String account; private String disclamier; private String sort;
	 * private String type; private String start; private String retformat;
	 * 
	 * public ImslpUrlBuilder(String start) { this.start = start; }
	 * 
	 * public ImslpUrlBuilder(String type, String start) { this.start = start;
	 * this.type = type; }
	 * 
	 * public ImslpUrlBuilder setAccount() { this.account = "worklist"; return this;
	 * }
	 * 
	 * public ImslpUrlBuilder setAccount(String account) { this.account = account;
	 * return this; }
	 * 
	 * public ImslpUrlBuilder setSort() { this.sort = ""; return this; }
	 * 
	 * public ImslpUrlBuilder setSort(String sort) { this.sort = sort; return this;
	 * }
	 */

	public String defaultTypeURLSetting(int start) {
		return "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start="
				+ start + "/retformat=json";
	}

	public String defaultURLSetting(int start, int type) {
		return "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=" + type
				+ "/start=" + start + "/retformat=json";
	}

}
