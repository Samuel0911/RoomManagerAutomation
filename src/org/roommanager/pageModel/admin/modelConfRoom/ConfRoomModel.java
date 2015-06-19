package org.roommanager.pageModel.admin.modelConfRoom;

import org.openqa.selenium.By;

public enum ConfRoomModel {
	
	
	LINK_CONFROOM_MENU(By.linkText("Conference Rooms")),
	DOUBLE_CLICK_ROOM(By.xpath("//div[@id='roomsGrid']/div[2]/div/div[3]/div[3]/div[2]/div/span[2]")),
	SEARCH_TEXT(By.xpath("//input[@type='text']"));
	
	public By value;
	
	private ConfRoomModel(By valueLocator){
		this.value = valueLocator;
	}

}
