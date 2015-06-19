package org.roommanager.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class PropertyReader {
	private static Properties prop = new Properties();
	private static InputStream input = null;	
	private static Properties getPropertyReader(){
	 try {		 
		input = new FileInputStream("configuration\\roommanager.properties");
 
		// load a properties file
		prop.load(input);	 
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 return prop;
	 
	 }	
	
	public static String getUrl(){
		return getPropertyReader().getProperty("url");
	}
	
	public static String getUserName(){
		return getPropertyReader().getProperty("username");
	}
	
	public static String getPassword(){
		return getPropertyReader().getProperty("password");
	}
	
	public static String getChromeDriver(){
		return getPropertyReader().getProperty("chromedriver");
	}
}
