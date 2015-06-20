package org.roommanager.pageModel.admin.modelConfRoom;

import org.openqa.selenium.By;

public enum ConfRoomModel {
	
	
	LINK_CONFROOM_MENU(By.linkText("Conference Rooms")),
	DOUBLE_CLICK_ROOM(By.xpath("//div[@id='roomsGrid']/div[2]/div/div[3]/div[3]/div[2]/div/span[2]")),
	GET_FORM_PADRE(By.xpath("//div[@id='roomsGrid']/div[2]/div")),
	GET_ELEMENTS_HIJOS(By.xpath("div[3]/div[2]/div/span[2]")),
	GET_HIJO(By.xpath("div"));
	public By value;
	
	private ConfRoomModel(By valueLocator){
		this.value = valueLocator;
	}

}
