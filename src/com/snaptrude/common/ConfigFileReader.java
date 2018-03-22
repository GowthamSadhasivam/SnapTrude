package com.snaptrude.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class ConfigFileReader {	
	
	
	
	protected static Properties properties;
	protected final static String propertyFilePath= "./configs/Configuration.properties";
	@Test
	public static String readFile(String key)  {
		
		 properties=new Properties();
		try {
			InputStream input=new FileInputStream(propertyFilePath);
			try {
			properties.load(input); 
		   // System.out.println(properties.getProperty("userName"));
		 
			}catch (Exception e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException  e) {
			
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);

		}
		
		return properties.getProperty(key);
	}
	/*
	public String getdata(String key){
		String val = properties.getProperty(key);
		if(val!= null) return val;
		else throw new RuntimeException("key not specified in the Configuration.properties file.");		
	}*/


}
