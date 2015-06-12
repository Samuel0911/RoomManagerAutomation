package org.roommanager.pages.admin.locations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.modelAdmin.LoginModel;
import org.roommanager.pageModel.modelLocations.LocationsModel;

public class LocationsPage {
	WebDriver driver;	
	By linkLocationMenu = LocationsModel.LINK_LOCATION_MENU.value;	
	By AddLocationButton = LocationsModel.ADD_LOCATIONBUTTON.value;	
	By waitFormLocationInfo = LocationsModel.WAIT_LOCATION_INFO.value;	
	By locationTextName = LocationsModel.LOCATION_TEXT_NAME.value;	
	By locationTextDisplayName = LocationsModel.LOCATION_DISPLAY_NAME.value;	
	By saveLocationButton = LocationsModel.SAVE_LOCATION_BUTTON.value;
	//aqui entra los API y assert
	By removeButton = LocationsModel.REMOVE_BUTTON.value;
	By removeButtonForm = LocationsModel.REMOVE_BUTTON_FORM.value;
	
	public LocationsPage(WebDriver driver){
		this.driver = driver;		
	}
			
	public LocationsPage LocationLink(){
					    
		driver.findElement(linkLocationMenu).click();
		
		(new WebDriverWait(driver, 60))
	      .until(ExpectedConditions.presenceOfElementLocated(AddLocationButton));
		return this;
	}
	
	public LocationsPage AddLocation(){
		driver.findElement(AddLocationButton).click();
		
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(waitFormLocationInfo));
		return this;
	}
	
	public LocationsPage LocationTextName(){
		driver.findElement(locationTextName).clear();
		driver.findElement(locationTextName).sendKeys("NewLocation");
		return this;
	}
	
	public LocationsPage LocationTextDisplayName(){
		driver.findElement(locationTextDisplayName).clear();
	    driver.findElement(locationTextDisplayName).sendKeys("NewLocation");
	    return this;
	}
	
	public LocationsPage SaveLocationButton(){
		driver.findElement(saveLocationButton).click();
		return this;
	}
	
	public LocationsPage RefreshPage(){
		driver.navigate().refresh();
		(new WebDriverWait(driver, 30))
	    .until(ExpectedConditions.presenceOfElementLocated(linkLocationMenu));
		return this;
	}
	
	public LocationsPage SearchLocationText(){
		driver.findElement(linkLocationMenu).click();
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(AddLocationButton));
		return this;
	}
	
	//aqui entra los api y assert
	
	public LocationsPage RemoveButton(){
		driver.findElement(removeButton).click();
		return this;
	}
	
	public LocationsPage RemoveButtonForm(){
		driver.findElement(removeButtonForm).click();
		return this;
	}
	
	

}
