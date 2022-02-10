package com.piano.score.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ResultAvailableConvert implements AttributeConverter<Boolean, String>{

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		// TODO Auto-generated method stub
		return (attribute != null && attribute) ? "true" : "false";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return "true".equalsIgnoreCase(dbData);
	}
	

}
