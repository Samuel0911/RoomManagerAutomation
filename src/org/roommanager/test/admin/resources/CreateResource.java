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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateResource {
	private WebDriver driver;
	private String baseUrl;
	String nameResource = "NewResource";
	String displayNameResource = "MyResource";
	
	@BeforeTest
	public void setUpTest(){
		driver = BrowserManager.browserChrome();
		baseUrl = PropertyReader.getUrl();
	}	  

	@Test
	public void createResource(){

		driver.get(PropertyReader.getUrl());
		//driver.get(baseUrl);
		LoginPage login = new LoginPage(driver);	    
		login.setUsername(PropertyReader.getUserName());	    
		login.setPassword(PropertyReader.getPassword());	    

		MainMenuPage menu = login.clickSignInButton();	    

		ResourcePage resource = menu.ResourcesHyperLink();				
		AddResourcePage addResource = resource.AddResource();
		addResource.resourceTextName(nameResource);
		addResource.resourceTextDisplayName(displayNameResource);
		addResource.saveResourceButton();
		resource.ClickLastPage();
		resource.getResourceName(nameResource);
		
		Assert.assertEquals(resource.getResourceName(nameResource).trim(), nameResource);
						
}
	@AfterTest
	public void TearDownTest(){
		driver.get(baseUrl);
		LoginPage login = new LoginPage(driver);

		MainMenuPage menu = login.clickSignInButton();	    

		ResourcePage resource = menu.ResourcesHyperLink();
		resource.ClickLastPage();
		resource.clickResource(nameResource);
		System.out.println("estamos removiendo en create location");
		RemoveResourceFormPage rmResource = resource.RemoveButton();
		rmResource.removeResourceButton();
							
	}

	@AfterSuite
	public void tearDown() throws Exception {				
		driver.quit();	    
	}
		
		
		
		
		
		
		
						
	}

