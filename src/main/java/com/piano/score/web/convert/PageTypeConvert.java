package com.piano.score.web.convert;

import javax.persistence.AttributeConverter;

import com.piano.score.pagedomain.PageType;

public class PageTypeConvert implements AttributeConverter<PageType, String> {

	@Override
	public String convertToDatabaseColumn(PageType attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageType convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
