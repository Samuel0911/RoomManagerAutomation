package org.roommanager.test.admin.locations;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.roommanager.pages.admin.locations.AddLocationPage;
import org.roommanager.pages.admin.locations.LocationsPage;
import org.roommanager.pages.admin.locations.RemoveLocationPage;
import org.roommanager.pages.admin.login.LoginPage;
import org.roommanager.pages.admin.mainMenu.MainMenuPage;
import org.roommanager.utils.BrowserManager;
import org.roommanager.utils.PropertyReader;


public class CreateLocations {
	private WebDriver driver;
	private static String baseUrl;

	@BeforeSuite
	public void setUp() throws Exception {

		driver = BrowserManager.browserChrome();
	}

	@BeforeTest
	public void setUpTest(){
		baseUrl = PropertyReader.getUrl();
	}	  

	@Test 
	public void createLocation() throws Exception {

		String nameLocation = "New Location";
		String displayNameLocation = "Location";		  
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
		location.SearchLocationText();	
		location.getLastLocationText();
		
		assertEquals(displayNameLocation, location.getLastLocationText());
		    
	}

	@AfterTest
	public void TearDownTest(){
		driver.get(baseUrl);
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
	}

	@AfterSuite
	public void tearDown() throws Exception {				
		driver.quit();	    
	}
}