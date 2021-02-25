package com.trendyol.deeplink.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertGenericResponse {
	
	public enum Type {URL, DEEPLINK};

	private String converted;
	
	private Type type;
		
}


