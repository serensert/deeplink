package com.trendyol.deeplink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendyol.deeplink.entity.EntDeepLink2UrlReq;
import com.trendyol.deeplink.entity.EntDeepLink2UrlRes;
import com.trendyol.deeplink.entity.EntGenericReq;
import com.trendyol.deeplink.entity.EntGenericRes;
import com.trendyol.deeplink.entity.EntUrl2DeepLinkReq;
import com.trendyol.deeplink.entity.EntUrl2DeepLinkRes;
import com.trendyol.deeplink.exceptions.DeepLinkException;
import com.trendyol.deeplink.model.request.ConvertDeepLink2UrlRequest;
import com.trendyol.deeplink.model.request.ConvertGenericRequest;
import com.trendyol.deeplink.model.request.ConvertUrl2DeepLinkRequest;
import com.trendyol.deeplink.model.response.ConvertDeepLink2UrlResponse;
import com.trendyol.deeplink.model.response.ConvertGenericResponse;
import com.trendyol.deeplink.model.response.ConvertUrl2DeepLinkResponse;
import com.trendyol.deeplink.repository.IDeepLink2UrlReqRepo;
import com.trendyol.deeplink.repository.IDeepLink2UrlResRepo;
import com.trendyol.deeplink.repository.IGenericReqRepo;
import com.trendyol.deeplink.repository.IGenericResRepo;
import com.trendyol.deeplink.repository.IUrl2DeepLinkReqRepo;
import com.trendyol.deeplink.repository.IUrl2DeepLinkResRepo;
import com.trendyol.deeplink.service.DeepLinkService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/converter")
@Log4j2
public class DeepLinkController {

    @Autowired
    private DeepLinkService service;

    @Autowired
    private IUrl2DeepLinkReqRepo url2DeepLinkReqRepo;

    @Autowired
    private IUrl2DeepLinkResRepo url2DeepLinkResRepo;

    @Autowired
    private IDeepLink2UrlReqRepo deepLink2UrlReqRepo;

    @Autowired
    private IDeepLink2UrlResRepo deepLink2UrlResRepo;

    @Autowired
    private IGenericReqRepo genericReqRepo;

    @Autowired
    private IGenericResRepo genericResRepo;

    @PostMapping("/url2deeplink")
    public ResponseEntity<ConvertUrl2DeepLinkResponse> convertUrl2DeepLink(@RequestBody ConvertUrl2DeepLinkRequest request) throws DeepLinkException {
    	try {
        	EntUrl2DeepLinkReq requestData = new EntUrl2DeepLinkReq(request);
        	url2DeepLinkReqRepo.save(requestData);
    		ConvertUrl2DeepLinkResponse response = service.convert(request);
    		ResponseEntity<ConvertUrl2DeepLinkResponse> responseEntity = new ResponseEntity<ConvertUrl2DeepLinkResponse>(response, HttpStatus.OK);
    		url2DeepLinkResRepo.save(new EntUrl2DeepLinkRes(response, requestData.getID()));
    		return responseEntity;
		} catch (Exception e) {
			if (e instanceof DeepLinkException) {
				throw e;
			}
			log.fatal("Unexpected Error", e);
			throw new DeepLinkException(e.getMessage());
		}
    }

    @PostMapping("/deeplink2url")
    public ResponseEntity<ConvertDeepLink2UrlResponse> convertDeepLink2Url(@RequestBody ConvertDeepLink2UrlRequest request) throws DeepLinkException {
    	try {
        	EntDeepLink2UrlReq requestData = new EntDeepLink2UrlReq(request);
    		deepLink2UrlReqRepo.save(requestData);
    		ConvertDeepLink2UrlResponse response = service.convert(request);
    		ResponseEntity<ConvertDeepLink2UrlResponse> responseEntity = new ResponseEntity<ConvertDeepLink2UrlResponse>(response, HttpStatus.OK);
    		deepLink2UrlResRepo.save(new EntDeepLink2UrlRes(response, requestData.getID()));
    		return responseEntity;
		} catch (Exception e) {
			if (e instanceof DeepLinkException) {
				throw e;
			}
			log.fatal("Unexpected Error", e);
			throw new DeepLinkException(e.getMessage());
		}
    }

    @PostMapping("/generic")
    public ResponseEntity<ConvertGenericResponse> convert(@RequestBody ConvertGenericRequest request) throws DeepLinkException {
    	try {
    		EntGenericReq requestData = new EntGenericReq(request);
    		genericReqRepo.save(requestData);
    		ConvertGenericResponse response = service.convert(request);
    		ResponseEntity<ConvertGenericResponse> responseEntity = new ResponseEntity<ConvertGenericResponse>(response, HttpStatus.OK);
    		genericResRepo.save(new EntGenericRes(response, requestData.getID()));
    		return responseEntity;
		} catch (Exception e) {
			if (e instanceof DeepLinkException) {
				throw e;
			}
			log.fatal("Unexpected Error", e);
			throw new DeepLinkException(e.getMessage());
		}
    }

}