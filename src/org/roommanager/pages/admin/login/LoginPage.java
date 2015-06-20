package org.roommanager.pages.admin.login;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelAdmin.LoginModel;
import org.roommanager.pages.admin.login.LoginPage;
import org.roommanager.pages.admin.mainMenu.MainMenuPage;
import org.roommanager.utils.LogsMessages;


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
	    LogsMessages.info("Writting the User Name");
	}
	
	public void setPassword(String password){
		driver.findElement(passTextFiel).clear();
	    driver.findElement(passTextFiel).sendKeys(password);
	    LogsMessages.info("Writting the Password");
	}
	
	public MainMenuPage clickSignInButton(){		
		driver.findElement(sigInButton).click();
		LogsMessages.info("Clicking in the Sign In Button");		
		return new MainMenuPage(driver);
	}	

	
}
