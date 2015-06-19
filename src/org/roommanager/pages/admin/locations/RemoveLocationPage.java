package org.roommanager.pages.admin.locations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelLocations.RemoveLocationModel;

public class RemoveLocationPage {

	
	public RemoveLocationPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	WebDriver driver;

	By removeLocationButton = RemoveLocationModel.REMOVE_LOCATION_BUTTON.value;	
	
	public LocationsPage removeLocationButton(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(removeLocationButton));
		driver.findElement(removeLocationButton).click();
		
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.invisibilityOfElementLocated(removeLocationButton));
		return new LocationsPage(driver);
	}
}
