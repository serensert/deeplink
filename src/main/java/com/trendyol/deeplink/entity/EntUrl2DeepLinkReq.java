package com.trendyol.deeplink.entity;

import org.springframework.data.annotation.Id;

import com.trendyol.deeplink.model.request.ConvertUrl2DeepLinkRequest;
import com.trendyol.deeplink.util.DeepLinkUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntUrl2DeepLinkReq extends ConvertUrl2DeepLinkRequest {

	@Id
	private String ID;
	
	public EntUrl2DeepLinkReq(ConvertUrl2DeepLinkRequest base) {
		this(DeepLinkUtil.generateID());
		this.setUrl(base.getUrl());		
	}

}
