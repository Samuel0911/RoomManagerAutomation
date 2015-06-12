package org.roommanager.test.login;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//imports para el testNG
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.roommanager.pages.admin.login.LoginPage;
import org.roommanager.utils.*;

public class Login {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
	  driver = new ChromeDriver();

	  PropertyReader referencia = new PropertyReader();
	  
	baseUrl = referencia.getUrl();
	driver.manage().window().maximize();	    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
	  	  	 	  
	  driver.get(baseUrl);

    LoginPage login = new LoginPage(driver);
    login.setUsername("samuel");
    login.setPassword("pass");
                  
    (new WebDriverWait(driver, 60))
    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button")));	    	      				    
    login.clickSignInButton();
        
    (new WebDriverWait(driver, 60))
    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav/div[2]")));	    	      		
    login.setAssert("Room Manager");    
    
  }  
  
  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
