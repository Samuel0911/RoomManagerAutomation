package org.roommanager.pageModel.admin.modelLocations;

import org.openqa.selenium.By;

public enum RemoveLocationModel {
	
	REMOVE_LOCATION_BUTTON(By.cssSelector("button.btn.btn-primary"));
	
	public By value;
	
	private RemoveLocationModel(By valueLocator){
		this.value = valueLocator;
	}

}
