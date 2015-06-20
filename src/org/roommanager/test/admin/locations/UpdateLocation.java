package org.roommanager.test.admin.locations;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.locations.AddLocationPage;
import org.roommanager.pages.admin.locations.LocationsPage;
import org.roommanager.pages.admin.locations.RemoveLocationPage;
import org.roommanager.pages.admin.login.LoginPage;
import org.roommanager.pages.admin.mainMenu.MainMenuPage;
import org.roommanager.utils.BrowserManager;
import org.roommanager.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateLocation {
	private WebDriver driver;
	private static String baseUrl;

	String nameLocation = "New Location";
	String displayNameLocation = "Location";


	@BeforeTest
	public void setUpTest(){
		driver = BrowserManager.browserChrome();
		baseUrl = PropertyReader.getUrl();
		driver.get(baseUrl);	    
		LoginPage login = new LoginPage(driver);	    
		login.setUsername(PropertyReader.getUserName());	    
		login.setPassword(PropertyReader.getPassword());	    

		MainMenuPage menu = login.clickSignInButton();	    

		LocationsPage location = menu.LocationsHyperLink();
		location.LocationLink();
		AddLocationPage addLocation = location.AddLocation();
		addLocation.LocationTextName(nameLocation);
		addLocation.LocationTextDisplayName(displayNameLocation);

		location = addLocation.SaveLocationButton();
		location.RefreshPage(); 
	}

	@Test
	public void updateLocation(){
		nameLocation = "New Location Updated";
		displayNameLocation = "Location updated";

		baseUrl = PropertyReader.getUrl();
		driver.get(baseUrl);
		LoginPage login = new LoginPage(driver);	    
		login.setUsername(PropertyReader.getUserName());	    
		login.setPassword(PropertyReader.getPassword());
		login.clickSignInButton();

		MainMenuPage menu = login.clickSignInButton();	    

		LocationsPage location = menu.LocationsHyperLink();
		location.LocationLink();
		location.SearchLocationText();
		location.clickLastLocation();		 
		location.doubleClickLastLocation();

		AddLocationPage addLocation = new AddLocationPage(driver);

		addLocation.LocationTextName(nameLocation);
		addLocation.LocationTextDisplayName(displayNameLocation);

		location = addLocation.SaveLocationButton();

		location.RefreshPage(); 
		location.SearchLocationText();	
		location.getLastLocationText();	
		Assert.assertEquals(location.getLastLocationText(),displayNameLocation);

	}

	@AfterTest
	public void TearDownTest(){

		LoginPage login = new LoginPage(driver);

		MainMenuPage menu = login.clickSignInButton();	    

		LocationsPage location = menu
				.LocationsHyperLink()	  		    
				.SearchLocationText()
				.clickLastLocation();

		RemoveLocationPage removeLocation = location
				.RemoveButton();

		location = removeLocation
				.removeLocationButton();
		driver.get(baseUrl);
	}
}
