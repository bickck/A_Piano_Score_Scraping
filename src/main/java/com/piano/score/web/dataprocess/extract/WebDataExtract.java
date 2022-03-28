package com.piano.score.web.dataprocess.extract;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.piano.score.mvc.repodomain.page.BaseInformation;
import com.piano.score.mvc.repodomain.page.PageMetaData;
import com.piano.score.mvc.repodomain.page.WebPageData;
import com.piano.score.mvc.repodomain.page.PageScoreInfos;
import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.web.convert.WebDataConvert;
import com.piano.score.web.netconnect.ImslpConnect;
import com.piano.score.web.netconnect.ImslpConnectionImpl;

@Component
public class WebDataExtract implements DataExtract {

	@Autowired
	private ImslpConnect imslpConnect;

	@Override
	public WebPageData pageDataExtract(int type, int start) throws Exception {
		// TODO Auto-generated method stub
		WebDataConvert dataExtract = null;

		try {
			String result = imslpConnect.connectSiteGetJson(type, start);
			dataExtract = new WebDataConvert(result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new WebPageData(dataExtract.dataListExtract(), dataExtract.metadataExtract());
	}

	/**
	 * 
	 * 굳이 이걸 만들 필요가 있는지 의문
	 * 
	 * @return 웹 데이터 갯수
	 */

	@Override
	public Long typeOneWebDataCount() {
		// TODO Auto-generated method stub
		long result = 0;
		try {
			result = webDataCount(1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Long typeTwoWebDataCount() {
		// TODO Auto-generated method stub
		long result = 0;
		try {
			result = webDataCount(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * 이 함수 다시 짜야함 못생겼음;;
	 * 
	 * 탐색은 이분탐색으로 진행
	 * 
	 * 웹사이트 호출이 여러번 일어남
	 * 
	 * 같은 코드가 중복으로 발생함
	 * 
	 * @throws Exception
	 * 
	 */

	private int findEndData(int type) throws Exception {
		int end = 0;
		boolean isCheck = true;

		while (isCheck) {

			String data = imslpConnect.connectSiteGetJson(type, end);
			WebDataConvert dataExtractParser = new WebDataConvert(data);

			if (dataExtractParser.metadataExtract().isMoreResultAvailable()) {
				end += 10000;
			} else {
				isCheck = false;
			}
		}
		return end;
	}

	private long webDataCount(int type) throws Exception {
		int start = 0, end = findEndData(type), endData = 0;
		boolean isCheck = true;

		while (isCheck) {

			int mid = (end + start) / 2;

			String data = imslpConnect.connectSiteGetJson(type, mid);

			WebDataConvert dataExtractParser = new WebDataConvert(data);

			if (dataExtractParser.dataSize() == 1) {
				end = mid;
			}
			if (dataExtractParser.dataSize() > 1000) {
				start = mid;
			}
			if (dataExtractParser.dataSize() < 1000 && dataExtractParser.dataSize() > 1) {
				end = mid;

				data = imslpConnect.connectSiteGetJson(1, end);
				dataExtractParser = new WebDataConvert(data);
				endData = dataExtractParser.dataSize();
				isCheck = false;
			}
		}

		return (((end - 1) * 1000) + endData);
	}
}
