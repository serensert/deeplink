package com.trendyol.deeplink.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertUrl2DeeplinkResponse {

	String deeplink;
	
}