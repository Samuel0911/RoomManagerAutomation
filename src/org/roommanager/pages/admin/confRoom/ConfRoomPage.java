package org.roommanager.pages.admin.confRoom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelConfRoom.ConfRoomModel;



public class ConfRoomPage {
	WebDriver driver;
	String nameRoom = "SM-Room Updated";
	public ConfRoomPage(WebDriver driver){
		this.driver = driver;		
	}
	
	By linkConfRoomMenu = ConfRoomModel.LINK_CONFROOM_MENU.value;
	By doubleClickRoom = ConfRoomModel.DOUBLE_CLICK_ROOM.value; 
	By searchText = ConfRoomModel.SEARCH_TEXT.value;
	
	public ConfRoomPage confRoomHyperLink(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(linkConfRoomMenu));
		driver.findElement(linkConfRoomMenu).click();
		return new ConfRoomPage(driver);		
	}
	
	public RoomInfoPage doubleClickRoom(){
		Actions action = new Actions(driver);
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(doubleClickRoom));
		action.doubleClick(driver.findElement(doubleClickRoom));
		action.perform();
		return new RoomInfoPage(driver);
	}
	
	public void searchText(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(searchText));
		driver.findElement(searchText).clear();
		driver.findElement(searchText).sendKeys(nameRoom);
	}
	
	
	/*public void test(){
        WebElement padre = driver.findElement(By.xpath("//div[@id='roomsGrid']/div[2]/div"));
        
        List<WebElement> hijos = padre.findElements(By.xpath("div"));
                
        for(WebElement room:hijos ){
              room.findElement(By.xpath("div/div[2]/div/div/div/span")).click();
              System.out.println(room.getText());
        }
	

	
	}*/
}
