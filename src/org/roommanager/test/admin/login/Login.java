package org.roommanager.test.admin.login;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.roommanager.pageModel.admin.modelAdmin.LoginModel;
import org.roommanager.pages.admin.login.LoginPage;
import org.roommanager.utils.*;


public class Login {
  private WebDriver driver;
  private static String baseUrl;
  String expectedResult = "Room Manager";
  By actualResult = LoginModel.ACTUAL_RESULT_LOGIN.value;
  
  
  @BeforeSuite
  public void setUp() throws Exception {	 	  	  	
	driver = BrowserManager.browserChrome();	
  }
  
  @BeforeTest
  public void setUpTest(){
	  baseUrl = PropertyReader.getUrl();
  }

  @Test
  public void testLogin() throws Exception {
	  	  	 	  
	  driver.get(baseUrl);

    LoginPage login = new LoginPage(driver);
    login.setUsername(PropertyReader.getUserName());
    login.setPassword(PropertyReader.getPassword());
    login.clickSignInButton();
    
    (new WebDriverWait(driver, 60))
    .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Room Manager")));

    assertEquals(expectedResult, driver.findElement(actualResult).getText());
    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      	 
  }  
  
  @AfterSuite
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}
