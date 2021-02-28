package com.trendyol.deeplink.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.trendyol.deeplink.entity.EntDeepLinkApiException;
import com.trendyol.deeplink.repository.IDeepLinkApiExceptionRepo;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
    @Autowired
    private IDeepLinkApiExceptionRepo deepLinkApiExceptionRepo;

	
	@ExceptionHandler({ DeepLinkException.class })
	public ResponseEntity<Object> handleDeepLinkException(DeepLinkException ex) {
		DeepLinkApiException dlException = new DeepLinkApiException(HttpStatus.BAD_REQUEST, ex.getMessage());
		deepLinkApiExceptionRepo.save(new EntDeepLinkApiException(dlException));
	    return new ResponseEntity<Object>(dlException, new HttpHeaders(), dlException.getStatus());
	}
	
}
