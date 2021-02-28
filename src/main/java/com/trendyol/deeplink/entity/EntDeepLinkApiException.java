package com.trendyol.deeplink.entity;

import org.springframework.data.annotation.Id;

import com.trendyol.deeplink.exceptions.DeepLinkApiException;
import com.trendyol.deeplink.util.DeepLinkUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntDeepLinkApiException extends DeepLinkApiException{
	
	@Id
	private String ID;
	
	public EntDeepLinkApiException(DeepLinkApiException base) {
		this(DeepLinkUtil.generateID());
		this.setMessage(base.getMessage());
		this.setStatus(base.getStatus());
	}

}
