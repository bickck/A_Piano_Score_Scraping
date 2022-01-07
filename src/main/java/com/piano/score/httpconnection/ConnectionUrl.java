package com.piano.score.httpconnection;

public interface ConnectionUrl {

	//List of people (composers, performers, editors, etc.): http://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=0/retformat=<pretty|json|php|wddx>
	//List of works: http://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=2/start=0/retformat=<pretty|json|php|wddx>
	static String defaultUrl = "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/";
	static String mainUrl = "https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=/retformat=json";

	
}
