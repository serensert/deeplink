package com.trendyol.deeplink.entity;

import org.springframework.data.annotation.Id;

import com.trendyol.deeplink.model.request.ConvertGenericRequest;
import com.trendyol.deeplink.util.DeepLinkUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntGenericReq extends ConvertGenericRequest {
	
	@Id
	private String ID;
	
	public EntGenericReq(ConvertGenericRequest base) {
		this(DeepLinkUtil.generateID());
		this.setLink(base.getLink());		
	}

}
