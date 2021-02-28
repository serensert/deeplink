package com.trendyol.deeplink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trendyol.deeplink.entity.EntDeepLinkApiException;

@Repository
public interface IDeepLinkApiExceptionRepo extends CrudRepository<EntDeepLinkApiException, String>{

}
