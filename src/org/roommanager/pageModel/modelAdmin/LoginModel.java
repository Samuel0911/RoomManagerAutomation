package org.roommanager.pageModel.modelAdmin;

import org.openqa.selenium.By;

public enum LoginModel {
	USER_TEXT_FIELD(By.cssSelector("input[type=\"text\"]")),
	PASS_TEXT_FIELD(By.cssSelector("input[type=\"password\"]")),
	SIGN_IN_BUTTON(By.xpath("//button"));
	public By value;
	
	private LoginModel(By valueLocator){
		this.value = valueLocator;
	}

}
