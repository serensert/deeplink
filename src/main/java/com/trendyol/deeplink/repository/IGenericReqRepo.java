package com.trendyol.deeplink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trendyol.deeplink.entity.EntGenericReq;

@Repository
public interface IGenericReqRepo extends CrudRepository<EntGenericReq, String> {

}
