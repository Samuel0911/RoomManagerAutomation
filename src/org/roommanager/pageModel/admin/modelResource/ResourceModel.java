package org.roommanager.pageModel.admin.modelResource;

import org.openqa.selenium.By;

public enum ResourceModel {
	LINK_RESOURCE_MENU(By.linkText("Resources")),
	ADD_RESOURCE_BUTTON(By.xpath("//div/div/button")),
	CLICK_LAST_PAGE(By.xpath("(//button[@type='button'])[5]")),
	REMOVE_RESOURCE_BUTTON(By.id("btnRemove")),
	GET_STRING_RESOURCE(By.xpath("div[3]/div[2]/div/span")),
	GET_FORM_PADRE(By.xpath("//div[@id='resourcesGrid']/div[2]/div")),
	GET_ELEMENTS_HIJOS(By.xpath("div"));
	
	public By value;
	
	private ResourceModel(By valueResource){
		this.value = valueResource;
	}
}
