package org.roommanager.pageModel.admin.modelAdmin;

import org.openqa.selenium.By;

public enum LoginModel {
	USER_TEXT_FIELD(By.cssSelector("input[type=\"text\"]")),
	PASS_TEXT_FIELD(By.cssSelector("input[type=\"password\"]")),
	SIGN_IN_BUTTON(By.xpath("//button")),
	ACTUAL_RESULT_LOGIN(By.linkText("Room Manager"));
	public By value;
	
	private LoginModel(By valueLocator){
		this.value = valueLocator;
	}
}
