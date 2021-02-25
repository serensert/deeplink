package com.trendyol.deeplink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendyol.deeplink.model.request.ConvertDeeplink2UrlRequest;
import com.trendyol.deeplink.model.request.ConvertGenericRequest;
import com.trendyol.deeplink.model.request.ConvertUrl2DeeplinkRequest;
import com.trendyol.deeplink.model.response.ConvertDeeplink2UrlResponse;
import com.trendyol.deeplink.model.response.ConvertGenericResponse;
import com.trendyol.deeplink.model.response.ConvertUrl2DeeplinkResponse;
import com.trendyol.deeplink.service.DeepLinkService;


@RestController
@RequestMapping("/converter")
public class DeepLinkController {

    @Autowired
    private DeepLinkService service;

    @PostMapping("/url2deeplink")
    public ResponseEntity<ConvertUrl2DeeplinkResponse> convertUrl2DeepLink(@RequestBody ConvertUrl2DeeplinkRequest request) throws Exception {
    	ConvertUrl2DeeplinkResponse response = service.convert(request);
        return new ResponseEntity<ConvertUrl2DeeplinkResponse>(response, HttpStatus.OK);
    }

    @PostMapping("/deeplink2url")
    public ResponseEntity<ConvertDeeplink2UrlResponse> convertDeepLink2Url(@RequestBody ConvertDeeplink2UrlRequest request) throws Exception {
    	ConvertDeeplink2UrlResponse response = service.convert(request);
        return new ResponseEntity<ConvertDeeplink2UrlResponse>(response, HttpStatus.OK);
    }

    @PostMapping("/genericConverter")
    public ResponseEntity<ConvertGenericResponse> convert(@RequestBody ConvertGenericRequest request) throws Exception {
    	ConvertGenericResponse response = service.convert(request);
        return new ResponseEntity<ConvertGenericResponse>(response, HttpStatus.OK);
    }

}