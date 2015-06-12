package org.roommanager.pages.admin.login;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.roommanager.pageModel.modelAdmin.LoginModel;
import org.roommanager.pages.admin.login.LoginPage;
import org.roommanager.pages.admin.mainMenu.MainMenuPage;

public class LoginPage {
	WebDriver driver;
				
	//inicializar las variables	
	By usernameTextFiel = LoginModel.USER_TEXT_FIELD.value;
	By passTextFiel = LoginModel.PASS_TEXT_FIELD.value;
	By sigInButton = LoginModel.SIGN_IN_BUTTON.value;
		
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setUsername(String username){
		driver.findElement(usernameTextFiel).clear();
	    driver.findElement(usernameTextFiel).sendKeys(username);
	}
	
	public void setPassword(String password){
		driver.findElement(passTextFiel).clear();
	    driver.findElement(passTextFiel).sendKeys(password);
	}
	
	public MainMenuPage clickSignInButton(){
		
		driver.findElement(sigInButton).click();
		return new MainMenuPage(driver);
	}
	
	public void setAssert(String assertLogin){
		assertEquals(assertLogin, driver.findElement(By.linkText("Room Manager")).getText());
	}
	
}
