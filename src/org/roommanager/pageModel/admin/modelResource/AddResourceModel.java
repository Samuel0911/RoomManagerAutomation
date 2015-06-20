package org.roommanager.pageModel.admin.modelResource;

import org.openqa.selenium.By;

public enum AddResourceModel {

	RESOURCE_TEXT_NAME(By.xpath("(//input[@type='text'])[3]")),
	RESOURCE_DISPLAY_NAME(By.xpath("(//input[@type='text'])[4]")),
	SAVE_RESOURCE_BUTTON(By.cssSelector("button.info"));
	
	public By value;
	
	private AddResourceModel(By valueResource){
		this.value = valueResource;
	}
}
