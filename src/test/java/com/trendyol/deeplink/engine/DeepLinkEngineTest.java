package com.trendyol.deeplink.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.trendyol.deeplink.exceptions.DeepLinkException;

public class DeepLinkEngineTest {

	@Test
	void engineTest() throws Exception {
			
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
	
	@Test
	void malformedInputTest() {
		try {
			DeepLinkEngine.convertFromURL2DeepLink(null);
			fail("Exception should be thrown");
		} catch (Exception e) {
			assertEquals(new DeepLinkException("\"url\" parameter not found").getMessage(), e.getMessage());
		}
		try {
			DeepLinkEngine.convertFromURL2DeepLink("httsaww.trendyol.com/casio/saat-p-?boutiqueId=439892&merchantId=105064");
			fail("Exception should be thrown");
		} catch (Exception e) {
			assertTrue(e.getMessage().startsWith("Malformed URL: "));
		}
		try {
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trend.yol.com/casio/saat-p-?boutiqueId=439892&merchantId=105064");
			fail("Exception should be thrown");
		} catch (Exception e) {
			assertEquals(new DeepLinkException("Not a Trendyol URL").getMessage(), e.getMessage());
		}
		try {
			DeepLinkEngine.convertFromURL2DeepLink("https://www.trendyol.com/casio/saat-p-?boutiqueId=439892&merchantId=105064");
			fail("Exception should be thrown");
		} catch (Exception e) {
			assertEquals(new DeepLinkException("ContentId should be present for Product URLs").getMessage(), e.getMessage());
		}
		
		try {
			DeepLinkEngine.convertFromDeepLink2URL(null);
			fail("Exception should be thrown");
		} catch (Exception e) {
			assertEquals(new DeepLinkException("\"deeplink\" parameter not found").getMessage(), e.getMessage());
		}
		try {
			DeepLinkEngine.convertFromDeepLink2URL("trendyol://?Page=Orders");
			fail("Exception should be thrown");
		} catch (Exception e) {
			assertEquals(new DeepLinkException("Not a Trendyol specified DeepLink").getMessage(), e.getMessage());
		}
		try {
			DeepLinkEngine.convertFromDeepLink2URL("ty://?Page=Product&CampaignId=439892&MerchantId=105064");
			fail("Exception should be thrown");
		} catch (Exception e) {
			assertEquals(new DeepLinkException("ContentId should be included for Product Deeplinks").getMessage(), e.getMessage());
		}
		
	}
}
