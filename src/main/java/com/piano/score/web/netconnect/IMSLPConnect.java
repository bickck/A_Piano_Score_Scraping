package com.piano.score.web.netconnect;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.piano.score.domain.ScoreMetaData;

public interface IMSLPConnect {

	// List of people (composers, performers, editors, etc.):
	// http://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=0/retformat=<pretty|json|php|wddx>
	// List of works:
	// http://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=2/start=0/retformat=<pretty|json|php|wddx>
	static String defaultUrl = "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/";
	static String mainUrl = "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=/retformat=json";
	static String typeAndStartUrl = "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/";

	String connectToIMSLP(String url) throws Exception;

	String defaultUrlSetting(String sort, Integer type, Integer start);

	String typeAndStartUrlSetting(Integer type, Integer start);

	boolean moreresultsavailable() throws ParseException;

}
