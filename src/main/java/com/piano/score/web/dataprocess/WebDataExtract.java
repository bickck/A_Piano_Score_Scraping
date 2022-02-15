package com.piano.score.web.dataprocess;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.piano.score.mvc.repository.BaseInfoRepository;
import com.piano.score.mvc.repositorydomain.BaseInformation;
import com.piano.score.mvc.repositorydomain.MetaData;
import com.piano.score.mvc.repositorydomain.OutPutDataList;
import com.piano.score.mvc.repositorydomain.ScoreList;
import com.piano.score.pagedomain.PageData;
import com.piano.score.pagedomain.PageScoreList;
import com.piano.score.web.convert.WebDataConvert;
import com.piano.score.web.netconnect.ImslpConnect;
import com.piano.score.web.netconnect.ImslpConnectionImpl;

@Configuration
public class WebDataExtract implements DataExtract {

	@Autowired
	private ImslpConnect imslpConnect;

	public WebDataExtract() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public OutPutDataList pageDataExtract(int type, int start) throws Exception {
		// TODO Auto-generated method stub
		WebDataConvert dataExtract = null;
		PageScoreList data = null;

		try {
			String url = imslpConnect.typeAndStartUrlSet(type, start);
			String result = imslpConnect.connectToIMSLP(url);
			dataExtract = new WebDataConvert(result);
			// data = new PageScoreList(dataExtract.dataListExtract(),
			// dataExtract.metadataExtract());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new OutPutDataList(dataExtract.dataListExtract(),dataExtract.metadataExtract());
	}

	@Override
	public Long typeOneWebDataCount() {
		// TODO Auto-generated method stub
		Long result = (long) 0;
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
		Long result = (long) 0;
		try {
			result = webDataCount(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private Long webDataCount(int type) throws Exception {
		int start = 0, end = 0, endData = 0;
		boolean isCheck = true;
		// 탐색 알고리즘

		Long StartTime = System.currentTimeMillis();

		while (isCheck) {

			String url = imslpConnect.typeAndStartUrlSet(type, end);
			String data = imslpConnect.connectToIMSLP(url);
			WebDataConvert dataExtractParser = new WebDataConvert(data);

			if (dataExtractParser.metadataExtract().isMoreResultAvailable()) {
				end += 10000;
			} else {
				isCheck = false;
			}
		}
		System.out.println(end);
		isCheck = true;

		while (isCheck) {

			int mid = (end + start) / 2;

			String url = imslpConnect.typeAndStartUrlSet(type, mid);
			String data = imslpConnect.connectToIMSLP(url);
			WebDataConvert dataExtractParser = new WebDataConvert(data);

			if (dataExtractParser.dataSize() == 1) {
				end = mid;
			}
			if (dataExtractParser.dataSize() > 1000) {
				start = mid;
			}
			if (dataExtractParser.dataSize() < 1000 && dataExtractParser.dataSize() > 1) {
				end = mid;
				url = imslpConnect.typeAndStartUrlSet(1, end);
				data = imslpConnect.connectToIMSLP(url);
				dataExtractParser = new WebDataConvert(data);
				endData = dataExtractParser.dataSize();
				isCheck = false;
			}
		}
		Long EndTime = System.currentTimeMillis();

		System.out.println("time : " + (EndTime - StartTime) / 1000 + "초");

		return (long) (((end - 1) * 1000) + endData);
	}
}
