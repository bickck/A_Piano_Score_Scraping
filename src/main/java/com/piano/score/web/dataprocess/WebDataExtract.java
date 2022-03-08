package com.piano.score.web.dataprocess;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.piano.score.mvc.repodomain.page.BaseInformation;
import com.piano.score.mvc.repodomain.page.PageMetaData;
import com.piano.score.mvc.repodomain.page.WebPageData;
import com.piano.score.mvc.repodomain.page.PageUrlList;
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

			String result = imslpConnect.connectWebSite(type, start);
			dataExtract = new WebDataConvert(result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new WebPageData(dataExtract.dataListExtract(), dataExtract.metadataExtract());
	}

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

	private long webDataCount(int type) throws Exception {
		int start = 0, end = 0, endData = 0;
		boolean isCheck = true;

		while (isCheck) {

			String data = imslpConnect.connectWebSite(type, end);
			WebDataConvert dataExtractParser = new WebDataConvert(data);

			if (dataExtractParser.metadataExtract().isMoreResultAvailable()) {
				end += 10000;
			} else {
				isCheck = false;
			}
		}

		isCheck = true;

		while (isCheck) {

			int mid = (end + start) / 2;

			String data = imslpConnect.connectWebSite(type, mid);

			WebDataConvert dataExtractParser = new WebDataConvert(data);

			if (dataExtractParser.dataSize() == 1) {
				end = mid;
			}
			if (dataExtractParser.dataSize() > 1000) {
				start = mid;
			}
			if (dataExtractParser.dataSize() < 1000 && dataExtractParser.dataSize() > 1) {
				end = mid;

				data = imslpConnect.connectWebSite(1, end);
				dataExtractParser = new WebDataConvert(data);
				endData = dataExtractParser.dataSize();
				isCheck = false;
			}
		}

		return (((end - 1) * 1000) + endData);
	}

	public void Test() {

		try {
			throw new Exception("오류");
		} catch (Exception e) {

		}

	}
}
