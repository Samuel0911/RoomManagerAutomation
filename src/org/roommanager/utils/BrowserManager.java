package org.roommanager.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {
	
	public static WebDriver driver;
			
	public static WebDriver browserChrome(){
		
			if(driver == null){
				System.setProperty("webdriver.chrome.driver", PropertyReader.getChromeDriver());
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			return driver;
		}

}
