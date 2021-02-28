package com.trendyol.deeplink.util;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class DeepLinkUtil {
	private static final SimpleDateFormat HUMAN_READABLE = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
	private static final SimpleDateFormat TIME_STAMP = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	public static String getHumanReadable(long epochTime) {
		return HUMAN_READABLE.format(epochTime);
	}
	
	public static String getTimeStamp() {
		return TIME_STAMP.format(System.currentTimeMillis());
	}
	
	public static String generateID() {
		return getTimeStamp() + "-" + UUID.randomUUID();
	}

}
