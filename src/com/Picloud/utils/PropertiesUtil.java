package com.Picloud.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public  class PropertiesUtil {
	
	public static String getValue(String key){
		Properties mProperties = new Properties();
		try {
			mProperties.load(new FileInputStream("src/config.properties"));
			return mProperties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
