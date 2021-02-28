package com.trendyol.deeplink.service;

import org.springframework.stereotype.Service;

import com.trendyol.deeplink.engine.DeepLinkEngine;
import com.trendyol.deeplink.exceptions.DeepLinkException;
import com.trendyol.deeplink.model.request.ConvertDeepLink2UrlRequest;
import com.trendyol.deeplink.model.request.ConvertGenericRequest;
import com.trendyol.deeplink.model.request.ConvertUrl2DeepLinkRequest;
import com.trendyol.deeplink.model.response.ConvertDeepLink2UrlResponse;
import com.trendyol.deeplink.model.response.ConvertGenericResponse;
import com.trendyol.deeplink.model.response.ConvertUrl2DeepLinkResponse;


@Service
public class DeepLinkService {

    public ConvertDeepLink2UrlResponse convert(ConvertDeepLink2UrlRequest request) throws DeepLinkException {
        return new ConvertDeepLink2UrlResponse(DeepLinkEngine.convertFromDeepLink2URL(request.getDeeplink()));
    }

    public ConvertUrl2DeepLinkResponse convert(ConvertUrl2DeepLinkRequest request) throws DeepLinkException {
        return new ConvertUrl2DeepLinkResponse(DeepLinkEngine.convertFromURL2DeepLink(request.getUrl()));
    }

    public ConvertGenericResponse convert(ConvertGenericRequest request) throws DeepLinkException {
		if (request.getLink().startsWith("https")) {
			return new ConvertGenericResponse(DeepLinkEngine.convertFromURL2DeepLink(request.getLink()), ConvertGenericResponse.Type.DEEPLINK);
		} else if (request.getLink().startsWith("ty://?")) {
			return new ConvertGenericResponse(DeepLinkEngine.convertFromDeepLink2URL(request.getLink()), ConvertGenericResponse.Type.URL);
		} else {
			throw new DeepLinkException("Not a URL or a DeepLink");
		}
    }
}
