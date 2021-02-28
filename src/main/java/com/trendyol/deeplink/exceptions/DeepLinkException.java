package com.trendyol.deeplink.exceptions;

import lombok.Data;

@Data
public class DeepLinkException extends RuntimeException {
	
	public DeepLinkException(String message) {
		super(message);
	}

}
