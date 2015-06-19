package org.roommanager.pages.admin.locations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelLocations.AddLocationModel;
import org.roommanager.pages.admin.mainMenu.MainMenuPage;

public class AddLocationPage {	
	public AddLocationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	WebDriver driver;
	By locationTextName = AddLocationModel.LOCATION_TEXT_NAME.value;	
	By locationTextDisplayName = AddLocationModel.LOCATION_DISPLAY_NAME.value;	
	By saveLocationButton = AddLocationModel.SAVE_LOCATION_BUTTON.value;
 

	public AddLocationPage LocationTextName(String nameLocation){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(locationTextName));
		driver.findElement(locationTextName).clear();
		driver.findElement(locationTextName).sendKeys(nameLocation);
		return this;
	}
	
	public AddLocationPage LocationTextDisplayName(String displayNameLocation){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(locationTextDisplayName));
		driver.findElement(locationTextDisplayName).clear();		
	    driver.findElement(locationTextDisplayName).sendKeys(displayNameLocation);
	    return this;
	}
	
	public LocationsPage SaveLocationButton(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(saveLocationButton));
		driver.findElement(saveLocationButton).click();
		
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.invisibilityOfElementLocated(saveLocationButton));
		return new LocationsPage(driver);		
	}	
	

}
