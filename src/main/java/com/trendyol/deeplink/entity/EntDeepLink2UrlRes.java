package com.trendyol.deeplink.entity;

import org.springframework.data.annotation.Id;

import com.trendyol.deeplink.model.response.ConvertDeepLink2UrlResponse;
import com.trendyol.deeplink.util.DeepLinkUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntDeepLink2UrlRes extends ConvertDeepLink2UrlResponse{
	
	@Id
	private String ID;
	
	private String relatedRequestID;

	public EntDeepLink2UrlRes(ConvertDeepLink2UrlResponse base, String relatedRequestID) {
		this(DeepLinkUtil.generateID(), relatedRequestID);
		this.setUrl(base.getUrl());
	}

}
