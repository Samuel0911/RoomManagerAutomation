package org.roommanager.pages.admin.resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelLocations.LocationsModel;
import org.roommanager.pageModel.admin.modelResource.ResourceModel;
import org.roommanager.pages.admin.locations.AddLocationPage;
import org.roommanager.pages.admin.locations.LocationsPage;
import org.roommanager.pages.admin.locations.RemoveLocationPage;
import org.roommanager.utils.LogsMessages;

public class ResourcePage {
	WebDriver driver;
	
	public ResourcePage(WebDriver driver){
		this.driver = driver;
	}
	
	By linkResourceMenu = ResourceModel.LINK_RESOURCE_MENU.value;
	By AddResourceButton = ResourceModel.ADD_RESOURCE_BUTTON.value;	
	By clickLastPage = ResourceModel.CLICK_LAST_PAGE.value;
	By removeResourceButton = ResourceModel.REMOVE_RESOURCE_BUTTON.value;
	By getStringResource =  ResourceModel.GET_STRING_RESOURCE.value;
	By getFormPadre = ResourceModel.GET_FORM_PADRE.value;
	By getElementsHijos = ResourceModel.GET_ELEMENTS_HIJOS.value;
	
	
	public ResourcePage ResourceLink(){
		(new WebDriverWait(driver, 60))
	      .until(ExpectedConditions.presenceOfElementLocated(linkResourceMenu));	    
		driver.findElement(linkResourceMenu).click();
		LogsMessages.info("Click on the Link Resource of the main menu");
		return this;
	}
	
	public AddResourcePage AddResource(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(AddResourceButton));
		driver.findElement(AddResourceButton).click();
		LogsMessages.info("Click on the Add button of the page Resource");
		return new AddResourcePage(driver);
	}
	
	public ResourcePage ClickLastPage(){
		(new WebDriverWait(driver, 60))
		.until(ExpectedConditions.presenceOfElementLocated(clickLastPage));
		driver.findElement(clickLastPage).click();
		LogsMessages.info("Searching for the last last page");		
		return this;
	}
	
	public ResourcePage clickResource(String nameOfResource){
		WebElement resource = searchResourceName(nameOfResource);
		resource.click();
		LogsMessages.info("Clicking on the resource");
		return this;
	}
	

	public String getResourceName(String resourcesName){
		WebElement resource = searchResourceName(resourcesName);
		String name = resource.findElement(getStringResource).getText();
		LogsMessages.info("Getting a resource name: "+ name);
		return name;
	}
	
	public boolean getResourceAssertion(String resName){
		WebElement resource = searchResourceName(resName);
		if(resource == null)
			return true;
		else
			return false;

	}
	
	private WebElement searchResourceName(String name){
		(new WebDriverWait(driver, 60))
	    	.until(ExpectedConditions.presenceOfElementLocated(getFormPadre));																		
        WebElement formPadre = driver.findElement(getFormPadre);
        List<WebElement> hijos = formPadre.findElements(getElementsHijos);
        
        for (WebElement roomHijo : hijos) {
			String resourceName = roomHijo.findElement(getStringResource).getText();		
			if(resourceName.equals(name)){
				return roomHijo;
			}
		}
        return null;
    }
	
	public RemoveResourceFormPage RemoveButton(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(removeResourceButton));
		driver.findElement(removeResourceButton).click();
		LogsMessages.info("Click on remove button of the Resource page");
		return new RemoveResourceFormPage(driver);
		
	}
	
}
