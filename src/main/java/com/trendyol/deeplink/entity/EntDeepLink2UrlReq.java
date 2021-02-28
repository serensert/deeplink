package com.trendyol.deeplink.entity;

import org.springframework.data.annotation.Id;

import com.trendyol.deeplink.model.request.ConvertDeepLink2UrlRequest;
import com.trendyol.deeplink.util.DeepLinkUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntDeepLink2UrlReq extends ConvertDeepLink2UrlRequest {
	
	@Id
	private String ID;
	
	public EntDeepLink2UrlReq(ConvertDeepLink2UrlRequest base) {
		this(DeepLinkUtil.generateID());
		this.setDeeplink(base.getDeeplink());		
	}

}
