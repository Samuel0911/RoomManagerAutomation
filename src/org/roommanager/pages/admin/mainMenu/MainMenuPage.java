package org.roommanager.pages.admin.mainMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.locations.LocationsPage;

public class MainMenuPage {	
	
	WebDriver driver;
		public MainMenuPage(WebDriver driver){
			this.driver = driver;
	}
	public LocationsPage clickLocationLink (){
		driver.findElement(By.linkText("Locations")).click();
		return new LocationsPage(driver);
		
	} 	
		
}
