package org.roommanager.pages.admin.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelResource.AddResourceModel;
import org.roommanager.utils.LogsMessages;


public class AddResourcePage {
	WebDriver driver;
	public AddResourcePage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	By resourceTextName = AddResourceModel.RESOURCE_TEXT_NAME.value;	
	By resourceTextDisplayName = AddResourceModel.RESOURCE_DISPLAY_NAME.value;	
	By saveResourceButton = AddResourceModel.SAVE_RESOURCE_BUTTON.value;
	
	public AddResourcePage resourceTextName(String nameResource){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(resourceTextName));
		driver.findElement(resourceTextName).clear();
		LogsMessages.info("Adding a new Resource on NameResource");
		driver.findElement(resourceTextName).sendKeys(nameResource);
		return this;
	}
	
	public AddResourcePage resourceTextDisplayName(String displayNameResource){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(resourceTextDisplayName));
		driver.findElement(resourceTextDisplayName).clear();		
		LogsMessages.info("Adding a new Resource on DisplayNameResource");
	    driver.findElement(resourceTextDisplayName).sendKeys(displayNameResource);
	    return this;
	}
	
	public ResourcePage saveResourceButton(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(saveResourceButton));
		driver.findElement(saveResourceButton).click();
		
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.invisibilityOfElementLocated(saveResourceButton));
		LogsMessages.info("Click on save Button");
		return new ResourcePage(driver);		
	}	
	
	
}
