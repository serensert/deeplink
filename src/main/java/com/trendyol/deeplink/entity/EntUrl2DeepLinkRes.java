package com.trendyol.deeplink.entity;

import org.springframework.data.annotation.Id;

import com.trendyol.deeplink.model.response.ConvertUrl2DeepLinkResponse;
import com.trendyol.deeplink.util.DeepLinkUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntUrl2DeepLinkRes extends ConvertUrl2DeepLinkResponse {

	@Id
	private String ID;
	
	private String relatedRequestID;

	public EntUrl2DeepLinkRes(ConvertUrl2DeepLinkResponse base, String relatedRequestID) {
		this(DeepLinkUtil.generateID(), relatedRequestID);
		this.setDeeplink(base.getDeeplink());
	}

}
