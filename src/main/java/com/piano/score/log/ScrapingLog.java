package com.piano.score.log;

import org.aspectj.lang.annotation.Pointcut;

public class ScrapingLog {
	
	@Pointcut("exceution(* *(..))")
	private void log() {}

}
