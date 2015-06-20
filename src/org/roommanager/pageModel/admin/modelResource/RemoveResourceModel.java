package org.roommanager.pageModel.admin.modelResource;

import org.openqa.selenium.By;

public enum RemoveResourceModel {
	REMOVE_RESOURCE_FORM_BUTTON(By.cssSelector("button.info"));
	
	public By value;
	
	private RemoveResourceModel(By valueResource){
		this.value = valueResource;
	}

}
