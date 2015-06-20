package org.roommanager.test.admin.resources;

import org.openqa.selenium.WebDriver;
import org.roommanager.pages.admin.login.LoginPage;
import org.roommanager.pages.admin.mainMenu.MainMenuPage;
import org.roommanager.pages.admin.resources.AddResourcePage;
import org.roommanager.pages.admin.resources.RemoveResourceFormPage;
import org.roommanager.pages.admin.resources.ResourcePage;
import org.roommanager.utils.BrowserManager;
import org.roommanager.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteResource {
	private WebDriver driver;
	private String baseUrl;
	String nameResource = "NewResource";
	String displayNameResource = "MyResource";
	
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

		ResourcePage resource = menu.ResourcesHyperLink();
		resource.ResourceLink();
		AddResourcePage addResource = resource.AddResource();
		
		addResource.resourceTextName(nameResource);
		addResource.resourceTextDisplayName(displayNameResource);
		addResource.saveResourceButton();
	}	  

	@Test
	public void deleteResource(){
		baseUrl = PropertyReader.getUrl();
		driver.get(baseUrl);
		
		LoginPage login = new LoginPage(driver);

		MainMenuPage menu = login.clickSignInButton();	    

		ResourcePage resource = menu.ResourcesHyperLink();
		resource.ClickLastPage();
		resource.clickResource(nameResource);
		
		RemoveResourceFormPage rmResource = resource.RemoveButton();
		rmResource.removeResourceButton();
								
		Assert.assertTrue(resource.getResourceAssertion(nameResource)); 				
}

	@AfterSuite
	public void tearDown() throws Exception {				
		driver.quit();	    
	}
		
		
}
