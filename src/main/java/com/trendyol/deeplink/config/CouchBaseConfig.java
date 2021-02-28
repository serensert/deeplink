package com.trendyol.deeplink.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "database")
@Data
public class CouchBaseConfig extends AbstractCouchbaseConfiguration {
	
	private String hostname;
	private String user;
	private String pass;
	private String bucket;
	

	@Override
	public String getConnectionString() {
		return hostname;
	}

	@Override
	public String getUserName() {
		return user;
	}

	@Override
	public String getPassword() {
		return pass;
	}

	@Override
	public String getBucketName() {
		return bucket;
	}
	
	//
//	@Override
//	public String getUserName() {
//		return "Administrator";
//	}
//
//	@Override
//	public String getPassword() {
//		return "trendyol2021";
//	}
//
//	@Override
//	public String getBucketName() {
//		return "ReqsAndResps";
//	}


}

