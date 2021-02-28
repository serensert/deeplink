package com.trendyol.deeplink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trendyol.deeplink.entity.EntGenericRes;


@Repository
public interface IGenericResRepo extends CrudRepository<EntGenericRes, String> {

}
