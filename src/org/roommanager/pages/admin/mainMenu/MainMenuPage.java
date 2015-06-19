package org.roommanager.pages.admin.mainMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelMainMenu.MainMenuModel;
import org.roommanager.pages.admin.confRoom.ConfRoomPage;
import org.roommanager.pages.admin.locations.LocationsPage;

public class MainMenuPage {	
	
	//By linkLocationMenu = LocationsModel.LINK_LOCATION_MENU.value;
	By linkLocationMenu = MainMenuModel.LINK_LOCATION_MENU.value;
	By linkResourceMenu = MainMenuModel.LINK_RESOURCE_MENU.value;
	By linkConfRoomMenu = MainMenuModel.LINK_CONF_ROOM_MENU.value;

					
WebDriver driver;
	
	public MainMenuPage(WebDriver driver){
		this.driver = driver;		
	}
	
    public void EmailServerHyperLink(){
    	driver.findElement(By.linkText("Email Servers")).click();
    }
	
	public void impersonationHyperLink(){
		driver.findElement(By.linkText("Impersonation")).click();
		
	}	
    
	public ConfRoomPage confRoomHyperLink(){		
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(linkConfRoomMenu));
		driver.findElement(linkConfRoomMenu).click();
		return new ConfRoomPage(driver);
		
	}
	
	public void ResourcesHyperLink(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(linkResourceMenu));
		driver.findElement(linkResourceMenu).click();
	}
    
	public LocationsPage LocationsHyperLink(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(linkLocationMenu));
		driver.findElement(linkLocationMenu).click();
		return new LocationsPage(driver);		
	}
    
		
}
