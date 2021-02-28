package com.trendyol.deeplink.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.trendyol.deeplink.entity.EntDeepLinkApiException;
import com.trendyol.deeplink.exceptions.DeepLinkApiException;
import com.trendyol.deeplink.repository.IDeepLinkApiExceptionRepo;

@SpringBootTest
public class DeepLinkRepoTest {
	
	@Autowired
	IDeepLinkApiExceptionRepo repo1;
	
	@Test
	void dbTest() {
		String savedEntityID = repo1.save(new EntDeepLinkApiException(new DeepLinkApiException(HttpStatus.BAD_REQUEST, "Test message"))).getID();
		assertEquals("Test message", repo1.findById(savedEntityID).get().getMessage());
		repo1.deleteById(savedEntityID);
	}
	
}
