package com.piano.score.scraping;

import java.io.IOException;

public interface ScoreScraping {

	void settingUrl(String urlName);

	void scraping() throws  Exception;
}
