package com.trendyol.deeplink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trendyol.deeplink.entity.EntDeepLink2UrlReq;

@Repository
public interface IDeepLink2UrlReqRepo extends CrudRepository<EntDeepLink2UrlReq, String> {

}
