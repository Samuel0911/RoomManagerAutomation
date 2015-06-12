package org.roommanager.test.locations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.roommanager.pages.admin.locations.LocationsPage;
import org.roommanager.pages.admin.login.LoginPage;
import org.roommanager.pages.admin.mainMenu.MainMenuPage;
import org.roommanager.utils.PropertyReader;

public class Locations {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	    
	  public PropertyReader referencia = new PropertyReader(); //instancia para el uso de los datos
	  
	  @BeforeTest
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		  driver = new ChromeDriver();
	    baseUrl = referencia.getUrl();
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test 
	  public void createLocation() throws Exception {
		   		
	    driver.get(baseUrl);
    	String username = "sam";
    	String password = "pass";
	    
    	LoginPage login = new LoginPage(driver);
	    
    	login.setUsername(username);	    
	    login.setPassword(password);
	    
	    MainMenuPage menu = login.clickSignInButton();
	    
	    LocationsPage location = menu.clickLocationLink();
	    location
		    .LocationLink()
		    .AddLocation()
		    .LocationTextName()
		    .LocationTextDisplayName()
		    .SaveLocationButton()
		    .RefreshPage()
		    .SearchLocationText();
	    	  
	    //para esto crear un request por api para q te devuelva el ultimo valor
	    int lastPosition = (((driver.findElements(By.xpath("//div[@id='locationGrid']/div[2]/div/*")))).size());	    
	    driver.findElement(By.xpath("//div[@id='locationGrid']/div[2]/div/div["+lastPosition+"]/div[2]/div[2]/div")).click();
	           	    
	    assertEquals("NewLocation", driver.findElement(By.xpath("//div[@id='locationGrid']/div[2]/div/div["+lastPosition+"]/div[2]/div[2]/div")).getText());
	    
		    location.RemoveButton();
		    location.RemoveButtonForm();
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
