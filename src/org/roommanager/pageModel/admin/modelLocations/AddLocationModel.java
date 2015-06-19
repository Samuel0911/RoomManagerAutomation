package org.roommanager.pageModel.admin.modelLocations;

import org.openqa.selenium.By;

public enum AddLocationModel {
	
	LOCATION_TEXT_NAME(By.id("location-add-name")),
	LOCATION_DISPLAY_NAME(By.id("location-add-display-name")),
	SAVE_LOCATION_BUTTON(By.cssSelector("button.btn.btn-primary"));
	
	public By value;
	
	private AddLocationModel(By valueLocator){
		this.value = valueLocator;
	}

}
