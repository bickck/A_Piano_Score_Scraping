package com.piano.score.web.netconnect;

import org.springframework.stereotype.Component;

/**

 * @author DongHyeon Kim
 * 
 * 
 * 이 문서는 URL에 데이터를 요청 가능한 형태로 url을 만들어줍니다.
 * 
 * @date 2022-03-22
 * 
 * 
 */

@Component
public class ImslpUrlBuilder {
	/*
	 * URL 링크 :
	 * https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=1/retformat=json
	 * 
	 * */

	public String defaultTypeURLSetting(int start) {
		return "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start="
				+ start + "/retformat=json";
	}

	public String defaultURLSetting(int start, int type) {
		return "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=" + type
				+ "/start=" + start + "/retformat=json";
	}

}
