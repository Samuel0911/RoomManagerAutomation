package org.roommanager.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class PropertyReader {
	Properties prop = new Properties();
	InputStream input = null;
	
	public PropertyReader(){
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
	 }	
	
	public String getUrl(){
		return prop.getProperty("url");
	}
	
	public String getUserName(){
		return prop.getProperty("username");
	}
	
	public String getPassword(){
		return prop.getProperty("password");
	}
}
