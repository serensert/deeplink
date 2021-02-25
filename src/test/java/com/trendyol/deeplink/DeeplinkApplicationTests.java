package com.trendyol.deeplink;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.trendyol.deeplink.engine.DeepLinkEngine;

@SpringBootTest
class DeeplinkApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("TEST START");
	}
	
	@Test
	void allExamples() throws Exception {
		
		for (int i = 0; i < 100000; i++) {
			
			assertEquals(DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064"), "ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064");
			assertEquals(DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/casio/erkek-kol-saati-p-1925865"), "ty://?Page=Product&ContentId=1925865");
			assertEquals(DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892"), "ty://?Page=Product&ContentId=1925865&CampaignId=439892");
			assertEquals(DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?merchantId=105064"), "ty://?Page=Product&ContentId=1925865&MerchantId=105064");
			assertEquals(DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/sr?q=elbise"), "ty://?Page=Search&Query=elbise");
			assertEquals(DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/sr?q=%C3%BCt%C3%BC"), "ty://?Page=Search&Query=%C3%BCt%C3%BC");
			assertEquals(DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/Hesabim/Favoriler"), "ty://?Page=Home");
			assertEquals(DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/Hesabim/#/Siparislerim"), "ty://?Page=Home");
			
			assertEquals(DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064"), "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892&merchantId=105064");
			assertEquals(DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Product&ContentId=1925865"), "https://www.trendyol.com/brand/name-p-1925865");
			assertEquals(DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Product&ContentId=1925865&CampaignId=439892"), "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892");
			assertEquals(DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Product&ContentId=1925865&MerchantId=105064"), "https://www.trendyol.com/brand/name-p-1925865?merchantId=105064");
			assertEquals(DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Search&Query=elbise"), "https://www.trendyol.com/sr?q=elbise");
			assertEquals(DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Search&Query=%C3%BCt%C3%BC"), "https://www.trendyol.com/sr?q=%C3%BCt%C3%BC");
			assertEquals(DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Favorites"), "https://www.trendyol.com/");
			assertEquals(DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Orders"), "https://www.trendyol.com/");
		}

	}
	
	@Test
	void allExamplesPerformance () throws Exception {
		
		for (int i = 0; i < 100000; i++) {
			
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064");
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/casio/erkek-kol-saati-p-1925865");
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?boutiqueId=439892");
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/casio/erkek-kol-saati-p-1925865?merchantId=105064");
			
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/sr?q=elbise");
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/sr?q=%C3%BCt%C3%BC");
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/Hesabim/Favoriler");
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/Hesabim/#/Siparislerim");
			
			DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064");
			DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Product&ContentId=1925865");
			DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Product&ContentId=1925865&CampaignId=439892");
			DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Product&ContentId=1925865&MerchantId=105064");
			
			DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Search&Query=elbise");
			DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Search&Query=%C3%BCt%C3%BC");
			DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Favorites");
			DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Orders");
		}
		
	}

}
