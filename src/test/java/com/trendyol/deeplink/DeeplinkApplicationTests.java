package com.trendyol.deeplink;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.trendyol.deeplink.engine.DeepLinkEngine;

@SpringBootTest
class DeepLinkApplicationTests {

	@Test
	void contextLoads() throws Exception {
		System.out.println("Application Started!");
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
