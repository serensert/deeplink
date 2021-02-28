package com.trendyol.deeplink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trendyol.deeplink.entity.EntUrl2DeepLinkReq;

@Repository
public interface IUrl2DeepLinkReqRepo extends CrudRepository<EntUrl2DeepLinkReq, String>{

}
