package org.roommanager.pageModel.admin.modelMainMenu;

import org.openqa.selenium.By;

public enum MainMenuModel {
	
	LINK_LOCATION_MENU(By.linkText("Locations")),
	WAIT_LOCATION_FORM(By.xpath("//div[4]/div")),
	LINK_RESOURCE_MENU(By.linkText("Resources")),
	WAIT_RESOURCE_FORM(By.xpath("//div[2]")),
	LINK_CONF_ROOM_MENU(By.linkText("Conference Rooms")),
	WAIT_CONF_ROOM_FORM(By.xpath("//div[@id='roomsGrid']/div/div[2]/div/div[3]/div[2]/div/div"));

	
	public By value;
	
	private MainMenuModel(By valueLocator){
		this.value = valueLocator;
	}

}
