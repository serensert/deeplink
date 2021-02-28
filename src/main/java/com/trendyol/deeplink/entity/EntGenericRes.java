package com.trendyol.deeplink.entity;

import org.springframework.data.annotation.Id;

import com.trendyol.deeplink.model.response.ConvertDeepLink2UrlResponse;
import com.trendyol.deeplink.model.response.ConvertGenericResponse;
import com.trendyol.deeplink.util.DeepLinkUtil;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class EntGenericRes extends ConvertGenericResponse{
	
	@Id
	private String ID;
	
	private String relatedRequestID;

	public EntGenericRes(ConvertGenericResponse base, String relatedRequestID) {
		this(DeepLinkUtil.generateID(), relatedRequestID);
		this.setType(base.getType());
		this.setConverted(base.getConverted());
	}

}
