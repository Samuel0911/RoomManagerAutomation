package org.roommanager.pages.admin.locations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelLocations.LocationsModel;
//import org.roommanager.pages.admin.mainMenu.MainMenuPage;
import org.roommanager.utils.LogsMessages;

public class LocationsPage {
	WebDriver driver;	
	By linkLocationMenu = LocationsModel.LINK_LOCATION_MENU.value;	
	By AddLocationButton = LocationsModel.ADD_LOCATIONBUTTON.value;	
	By waitFormLocationInfo = LocationsModel.WAIT_LOCATION_INFO.value;	
	By removeButton = LocationsModel.REMOVE_BUTTON.value;
	By removeButtonForm = LocationsModel.REMOVE_BUTTON_FORM.value;
	By findLocation = LocationsModel.FIND_LOCATION.value;

	public LocationsPage(WebDriver driver){
		this.driver = driver;		
	}

	public LocationsPage clickLastLocation(){
		(new WebDriverWait(driver, 60))
	      .until(ExpectedConditions.presenceOfElementLocated(findLocation));
		int lastPosition = (((driver.findElements(findLocation))).size());	
		driver.findElement((By.xpath("//div[@id='locationGrid']/div[2]/div/div["+lastPosition+"]/div[2]/div[2]/div"))).click();
		
		LogsMessages.info("Clicking on the last location created");
	    return this;
	}

	public LocationsPage doubleClickLastLocation(){
		Actions action = new Actions(driver);
		
		(new WebDriverWait(driver, 60))
	      .until(ExpectedConditions.presenceOfElementLocated(findLocation));
		int lastPosition = (((driver.findElements(findLocation))).size());				                        
        WebElement Link=new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@id='locationGrid']/div[2]/div/div["+lastPosition+"]/div[2]/div[2]/div"))));
        action.doubleClick(Link);
        action.perform();

		
		LogsMessages.info("Clicking on the last location created");
	    return this;
	}
	public String getLastLocationText(){
		(new WebDriverWait(driver, 60))
	      .until(ExpectedConditions.presenceOfElementLocated(findLocation));
		int lastPosition = (((driver.findElements(findLocation))).size());
		return driver.findElement(By.xpath("//div[@id='locationGrid']/div[2]/div/div["+lastPosition+"]/div[2]/div[2]/div")).getText();
	}
		
	public LocationsPage LocationLink(){
		(new WebDriverWait(driver, 60))
	      .until(ExpectedConditions.presenceOfElementLocated(linkLocationMenu));	    
		driver.findElement(linkLocationMenu).click();
		LogsMessages.info("Click on the Link Location of the main menu");
		return this;
	}
	
	public AddLocationPage AddLocation(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(AddLocationButton));
		driver.findElement(AddLocationButton).click();
		LogsMessages.info("Click on the Add button of the page Location");
		return new AddLocationPage(driver);
	}
		
	
	public LocationsPage RefreshPage(){
		driver.navigate().refresh();
		(new WebDriverWait(driver, 30))
	    .until(ExpectedConditions.presenceOfElementLocated(linkLocationMenu));
		LogsMessages.info("Updating the page");
		return this;
	}
	
	public LocationsPage SearchLocationText(){
		(new WebDriverWait(driver, 60))
		.until(ExpectedConditions.presenceOfElementLocated(linkLocationMenu));
		driver.findElement(linkLocationMenu).click();
		LogsMessages.info("Searching for the last location created");		
		return this;
	}
	
	
	public RemoveLocationPage RemoveButton(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(removeButton));
		driver.findElement(removeButton).click();
		LogsMessages.info("Click on remove button of the Location page");
		return new RemoveLocationPage(driver);
		
	}
			
}
