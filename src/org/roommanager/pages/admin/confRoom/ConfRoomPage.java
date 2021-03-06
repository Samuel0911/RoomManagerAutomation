package org.roommanager.pages.admin.confRoom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelConfRoom.ConfRoomModel;
import org.roommanager.utils.LogsMessages;



public class ConfRoomPage {
	WebDriver driver;
	String nameRoom = "SM-Room Updated";
	public ConfRoomPage(WebDriver driver){
		this.driver = driver;		
	}
	
	By linkConfRoomMenu = ConfRoomModel.LINK_CONFROOM_MENU.value;
	By doubleClickRoom = ConfRoomModel.DOUBLE_CLICK_ROOM.value; 
	By getFormPadre = ConfRoomModel.GET_FORM_PADRE.value;
	By getElementsHijo = ConfRoomModel.GET_ELEMENTS_HIJOS.value;
	By getHijo = ConfRoomModel.GET_HIJO.value;
	
	public ConfRoomPage confRoomHyperLink(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(linkConfRoomMenu));
		driver.findElement(linkConfRoomMenu).click();
		LogsMessages.info("Click on Conference Room hyperlink");
		return new ConfRoomPage(driver);		
	}
	
	public RoomInfoPage doubleClickRoom(){
		Actions action = new Actions(driver);
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(doubleClickRoom));
		action.doubleClick(driver.findElement(doubleClickRoom));
		action.perform();
		LogsMessages.info("Double Click on Conference Room Name");
		return new RoomInfoPage(driver);
	}
	
	public String getRoomName(String roomName){
		WebElement room = buscador(roomName);
		String name = room.getText();
		return name;
	}
	
	public WebElement buscador(String name){
		(new WebDriverWait(driver, 60))
	    	.until(ExpectedConditions.presenceOfElementLocated(getFormPadre));
        WebElement padre = driver.findElement(getFormPadre);
        List<WebElement> hijos = padre.findElements(getHijo);
        
        for (WebElement roomHijo : hijos) {
			String roomName = roomHijo.findElement(getElementsHijo).getText();
			if(roomName.equals(name)){
				return roomHijo;
			}
		}
        return null;
    }
	
	
}
