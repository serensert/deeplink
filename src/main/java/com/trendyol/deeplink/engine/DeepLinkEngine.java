package com.trendyol.deeplink.engine;


import java.net.MalformedURLException;
import java.net.URL;

import com.trendyol.deeplink.exceptions.DeepLinkException;

public class DeepLinkEngine {
	
	public static String convertFromURL2DeepLink(String strUrl) throws DeepLinkException {
		if (strUrl == null) {
			throw new DeepLinkException("\"url\" parameter not found");
		}
		URL url;
		try {
			url = new URL(strUrl);
		} catch (MalformedURLException e) {
			throw new DeepLinkException("Malformed URL: " + e.getMessage());
		}
		
		if ("www.trendyol.com".equals(url.getHost()) == false) {
			throw new DeepLinkException("Not a Trendyol URL");
		}
		
		String[] pathAsArr = url.getPath().substring(1).split("/");
		
		if ("sr".equals(pathAsArr[0])) {
			return convertFromSearchURL2DeepLink(url);
		} else if (pathAsArr.length >= 2 && pathAsArr[1].contains("-p-")) {
			return convertFromPDPURL2DeepLink(url, pathAsArr);
		} else {
			return "ty://?Page=Home";
		}
	}

	private static String convertFromSearchURL2DeepLink(URL url) {
		return "ty://?Page=Search&" + url.getQuery().replaceFirst("q=", "Query=");
		
		
	}
	
	private static String convertFromPDPURL2DeepLink(URL url, String[] pathAsList) throws DeepLinkException {
		String contendId = pathAsList[1].substring(pathAsList[1].indexOf("-p-") + 3);
		
		if ("".equals(contendId)) {
			throw new DeepLinkException("ContentId should be present for Product URLs");
		}

		String query = url.getQuery();
		
		if (query == null) {
			return "ty://?Page=Product&ContentId=" + contendId;
		}
		
		query = query.replaceFirst("boutiqueId=", "CampaignId=").replaceFirst("merchantId=", "MerchantId=");
		
		return "ty://?Page=Product&ContentId=" + contendId + "&" + query;
	}
	
	public static String convertFromDeepLink2URL(String strDeepLink) throws DeepLinkException {
		if (strDeepLink == null) {
			throw new DeepLinkException("\"deeplink\" parameter not found");
		}
		if (strDeepLink.startsWith("ty://?") == false) {
			throw new DeepLinkException("Not a Trendyol specified DeepLink");
		}
		if (strDeepLink.startsWith("ty://?Page=Product&")) {
			return convertFromPDPDeepLink2URL(strDeepLink);
		} else if (strDeepLink.startsWith("ty://?Page=Search&")) {
			return convertFromSearchDeepLink2URL(strDeepLink);
		} else {
			return "https://www.trendyol.com/";
		}
	}
	
	private static String convertFromPDPDeepLink2URL(String strDeepLink) throws DeepLinkException {
		String[] deepLinkQueriesArr = strDeepLink.substring(strDeepLink.indexOf("&ContentId=") + 1).split("&");
		String contentId = null;
		String campaignId = null;
		String merchantId = null;
		for (String parameter : deepLinkQueriesArr) {
			String[] parameterCouple = parameter.split("=");
			switch (parameterCouple[0]) {
			case "ContentId":
				contentId = parameterCouple[1];
				break;
			case "CampaignId":
				campaignId = parameterCouple[1];
				break;
			case "MerchantId":
				merchantId = parameterCouple[1];
				break;
			default:
				break;
			}
		}
		if (contentId == null) {
			throw new DeepLinkException("ContentId should be included for Product Deeplinks");
		}
		StringBuilder sb = new StringBuilder("https://www.trendyol.com/brand/name-p-" + contentId);
		
		if (campaignId != null) {
			sb.append("?boutiqueId=" + campaignId);
			if (merchantId != null) {
				sb.append("&merchantId=" + merchantId);
			}
		} else if (merchantId != null) {
			sb.append("?merchantId=" + merchantId);
		}
		
		return sb.toString();
	}

	private static String convertFromSearchDeepLink2URL(String strDeepLink) {
		return strDeepLink.replace("ty://?Page=Search&Query=", "https://www.trendyol.com/sr?q=");
	}

}