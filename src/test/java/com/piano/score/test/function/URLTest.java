package com.piano.score.test.function;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.jupiter.api.Test;


public class URLTest {

	

	@Test
	public void urlTest() throws Exception{
		
		URL urla = new URL("https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=1/retformat=json");
		URL urlb = new URL("http://www.naver.com");
		
		
		System.out.println(urla.getAuthority());
		System.out.println(urla.getQuery());
		System.out.println(urla.getFile());
		System.out.println(urlb.getAuthority());
		System.out.println(urlb.getDefaultPort());
		System.out.println(urlb.getQuery());
	
	}
	
	//@Test
	public void urlTest2() throws Exception{
		
		URL url = new URL("http://www.naver.com");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		
		while(bufferedReader.lines() != null) {
			System.out.println(bufferedReader.readLine());
		}
		
	}
}
