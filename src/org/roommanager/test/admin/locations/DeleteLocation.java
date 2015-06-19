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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(org.roommanager.utils.FailedScreenShot.class)
public class DeleteLocation {
	  private WebDriver driver;
	  private static String baseUrl;
	  
	  String nameLocation = "New Location";
	  String displayNameLocation = "Location";
	  
	  @BeforeSuite
	  public void setUp() throws Exception {
		  
		  driver = BrowserManager.browserChrome();
	  }
	 @BeforeTest
	  public void setUpTest(){
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
	 public void deleteLocation()throws Exception{
		 
		 LocationsPage location = new LocationsPage(driver);		 
		 
		 location.SearchLocationText();	
		 location.clickLastLocation();
		 
		 RemoveLocationPage removeLocation = location
				.RemoveButton();
				
			    location = removeLocation
			    	.removeLocationButton();
			    location.RefreshPage(); 			   
			   			    
			    Assert.assertNotSame(location.getLastLocationText(),displayNameLocation);			    			    
	 }
	 
	 @AfterTest
	 public void TearDownTest(){
		 
	 }

}
