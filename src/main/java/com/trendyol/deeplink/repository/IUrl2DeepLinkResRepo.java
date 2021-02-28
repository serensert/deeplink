package com.trendyol.deeplink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trendyol.deeplink.entity.EntUrl2DeepLinkRes;

@Repository
public interface IUrl2DeepLinkResRepo extends CrudRepository<EntUrl2DeepLinkRes, String>{

}
