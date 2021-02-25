package com.trendyol.deeplink.service;

import org.springframework.stereotype.Service;

import com.trendyol.deeplink.engine.DeepLinkEngine;
import com.trendyol.deeplink.model.request.ConvertDeeplink2UrlRequest;
import com.trendyol.deeplink.model.request.ConvertGenericRequest;
import com.trendyol.deeplink.model.request.ConvertUrl2DeeplinkRequest;
import com.trendyol.deeplink.model.response.ConvertDeeplink2UrlResponse;
import com.trendyol.deeplink.model.response.ConvertGenericResponse;
import com.trendyol.deeplink.model.response.ConvertUrl2DeeplinkResponse;

import ch.qos.logback.core.subst.Token.Type;


@Service
public class DeepLinkService {

    public ConvertDeeplink2UrlResponse convert(ConvertDeeplink2UrlRequest request) throws Exception {
        return new ConvertDeeplink2UrlResponse(DeepLinkEngine.convertFromDeepLink2URL(request.getDeeplink()));
    }

    public ConvertUrl2DeeplinkResponse convert(ConvertUrl2DeeplinkRequest request) throws Exception {
        return new ConvertUrl2DeeplinkResponse(DeepLinkEngine.convertFromURL2DeepLink(request.getUrl()));
    }

    public ConvertGenericResponse convert(ConvertGenericRequest request) throws Exception {
		if (request.getLink().startsWith("https")) {
			return new ConvertGenericResponse(DeepLinkEngine.convertFromURL2DeepLink(request.getLink()), ConvertGenericResponse.Type.URL);
		} else {
			return new ConvertGenericResponse(DeepLinkEngine.convertFromDeepLink2URL(request.getLink()), ConvertGenericResponse.Type.DEEPLINK);
		}
    }
}
