package com.trendyol.deeplink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trendyol.deeplink.entity.EntDeepLink2UrlRes;


@Repository
public interface IDeepLink2UrlResRepo extends CrudRepository<EntDeepLink2UrlRes, String> {

}
