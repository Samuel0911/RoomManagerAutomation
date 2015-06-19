package org.roommanager.pageModel.admin.modelLocations;

import org.openqa.selenium.By;

public enum LocationsModel {

	//USER_TEXT_FIELD(By.cssSelector("input[type=\"text\"]")),
	LINK_LOCATION_MENU(By.linkText("Locations")),
	ADD_LOCATIONBUTTON(By.xpath("//div[4]/div/button")),
	WAIT_LOCATION_INFO(By.cssSelector("div.modal-header.ng-scope")),
		
	REMOVE_BUTTON(By.xpath("//button[2]")),
	REMOVE_BUTTON_FORM(By.cssSelector("button.btn.btn-primary")),
	FIND_LOCATION(By.xpath("//div[@id='locationGrid']/div[2]/div/*"));
		
	public By value;
	
	private LocationsModel(By valueLocator){
		this.value = valueLocator;
	}
}
