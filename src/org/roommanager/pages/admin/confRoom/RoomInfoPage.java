package org.roommanager.pages.admin.confRoom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelConfRoom.ConfRoomInfoModel;
import org.roommanager.pageModel.admin.modelConfRoom.ConfRoomModel;
import org.roommanager.utils.LogsMessages;

public class RoomInfoPage {
	
	private WebDriver driver;
	private String baseUrl;
	
	String roomNameUpdated = "SM-Room Updated";
	String codeRoom = "30";
	String capacityRoom = "50";
	String nameOfRoomOriginal = "SM-Room11";
	
	By nameOfRoom = ConfRoomInfoModel.NAME_OF_ROOM.value;
	By codeOfRoom = ConfRoomInfoModel.CODE_OF_ROOM.value;
	By capacityOfRoom = ConfRoomInfoModel.CAPACITY_OF_ROOM.value;
	By saveButton = ConfRoomInfoModel.SAVE_BUTTON_OF_ROOM.value;
	By assertRoomUpdating = ConfRoomInfoModel.ASSERT_ROOM_UPDATE.value;
	By getFormPadre = ConfRoomModel.GET_FORM_PADRE.value;
	By getElementsHijo = ConfRoomModel.GET_ELEMENTS_HIJOS.value;
	By getHijo = ConfRoomModel.GET_HIJO.value;
	
	
	public RoomInfoPage(WebDriver driver){
		this.driver = driver;
	}
	
	public RoomInfoPage nameRoom(){

		WebElement textNameField = (new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(nameOfRoom));
		textNameField.clear();		
		textNameField.sendKeys(roomNameUpdated);
		return this;
	}
	
	public RoomInfoPage nameRoomOriginal(){
		
		WebElement textNameField = (new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(nameOfRoom));
		textNameField.clear();
		textNameField.sendKeys(nameOfRoomOriginal);
		return this;
	}
	
	public RoomInfoPage codeText(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(codeOfRoom));
		driver.findElement(codeOfRoom).clear();
		driver.findElement(codeOfRoom).sendKeys(codeRoom);
		LogsMessages.info("Write a code for a room");
		return this;
	}
	
	public RoomInfoPage capacityText(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(capacityOfRoom));
		driver.findElement(capacityOfRoom).clear();
		driver.findElement(capacityOfRoom).sendKeys(capacityRoom); 
		LogsMessages.info("Write a capacity for a room");
		return this;
	}
	
	public ConfRoomPage saveButtonForm(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(saveButton));
		driver.findElement(saveButton).click();
		LogsMessages.info("Click on save button");
		return new ConfRoomPage(driver);
	}
	
	public String assertRoomUpdate(){
					
		return driver.findElement(assertRoomUpdating).getText();
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
