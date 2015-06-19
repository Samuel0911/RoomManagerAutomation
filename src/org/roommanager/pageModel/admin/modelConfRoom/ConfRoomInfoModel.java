package org.roommanager.pageModel.admin.modelConfRoom;

import org.openqa.selenium.By;

public enum ConfRoomInfoModel {
	
	NAME_OF_ROOM(By.xpath("(//input[@type='text'])[4]")),
	CODE_OF_ROOM(By.xpath("(//input[@type='text'])[5]")),
	CAPACITY_OF_ROOM(By.xpath("(//input[@type='text'])[6]")),
	SAVE_BUTTON_OF_ROOM(By.cssSelector("button.info")),
	ASSERT_ROOM_UPDATE(By.xpath("//div[@id='roomsGrid']/div[2]/div/div/div[3]/div[2]/div/span[2]"));
	
	public By value;
	
	private ConfRoomInfoModel(By valueLocator){
		this.value = valueLocator;
	}

}
