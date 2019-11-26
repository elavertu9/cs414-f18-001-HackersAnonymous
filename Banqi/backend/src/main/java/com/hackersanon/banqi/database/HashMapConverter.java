package com.hackersanon.banqi.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;


@Converter(autoApply = true)
public class HashMapConverter implements AttributeConverter<Object, String>
{
	private final static ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Override
	public String convertToDatabaseColumn(Object stringObjectMap)
	{
		String gameJson = null;
		try{
			gameJson = objectMapper.writeValueAsString(stringObjectMap);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return gameJson;
	}
	
	@Override
	public Object convertToEntityAttribute(String s)
	{
		try{
			return objectMapper.readValue(s, Object.class);
		}
		catch (final IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
