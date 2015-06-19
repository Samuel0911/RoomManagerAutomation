package org.roommanager.pages.admin.locations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateLocationPage {
	
	
	public UpdateLocationPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	WebDriver driver;
	
	public void doubleClick(){
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//div[@id='roomsGrid']/div[2]/div/div[3]/div[3]/div[2]/div/span[2]")));
	    action.perform();
	}

}
