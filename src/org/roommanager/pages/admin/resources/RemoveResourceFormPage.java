package org.roommanager.pages.admin.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelResource.RemoveResourceModel;
import org.roommanager.utils.LogsMessages;

public class RemoveResourceFormPage {
	public RemoveResourceFormPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	WebDriver driver;

	By removeResourceButton = RemoveResourceModel.REMOVE_RESOURCE_FORM_BUTTON.value;	
	
	public ResourcePage removeResourceButton(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(removeResourceButton));
		LogsMessages.info("Click on remove button of the Resource form page");
		driver.findElement(removeResourceButton).click();
		
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.invisibilityOfElementLocated(removeResourceButton));
		return new ResourcePage(driver);
	}

}
