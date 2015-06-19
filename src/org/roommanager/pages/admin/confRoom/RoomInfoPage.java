package org.roommanager.pages.admin.confRoom;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.pageModel.admin.modelConfRoom.ConfRoomInfoModel;

public class RoomInfoPage {
	
	private WebDriver driver;
	private String baseUrl;
	
	String roomNameUpdated = "SM-Room Updated";
	String codeRoom = "30";
	String capacityRoom = "50";
	String nameOfRoomOriginal = "SM-Room10";
	
	By nameOfRoom = ConfRoomInfoModel.NAME_OF_ROOM.value;
	By codeOfRoom = ConfRoomInfoModel.CODE_OF_ROOM.value;
	By capacityOfRoom = ConfRoomInfoModel.CAPACITY_OF_ROOM.value;
	By saveButton = ConfRoomInfoModel.SAVE_BUTTON_OF_ROOM.value;
	By assertRoomUpdating = ConfRoomInfoModel.ASSERT_ROOM_UPDATE.value;
	
	
	public RoomInfoPage(WebDriver driver){
		this.driver = driver;
	}
	
	public RoomInfoPage nameRoom(){

		WebElement textNameField = (new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(nameOfRoom));
		String originalText = textNameField.getText();
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
		return this;
	}
	
	public RoomInfoPage capacityText(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(capacityOfRoom));
		driver.findElement(capacityOfRoom).clear();
		driver.findElement(capacityOfRoom).sendKeys(capacityRoom); 
		return this;
	}
	
	public ConfRoomPage saveButtonForm(){
		(new WebDriverWait(driver, 60))
	    .until(ExpectedConditions.presenceOfElementLocated(saveButton));
		driver.findElement(saveButton).click();
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
	    	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='roomsGrid']/div[2]/div")));
        WebElement padre = driver.findElement(By.xpath("//div[@id='roomsGrid']/div[2]/div"));
        List<WebElement> hijos = padre.findElements(By.xpath("div"));
        
        for (WebElement roomHijo : hijos) {
			String roomName = roomHijo.findElement(By.xpath("div[3]/div[2]/div/span[2]")).getText();
			System.out.println("este es el room name choy "+ roomName);
			if(roomName.equals(name)){
				return roomHijo;
			}
		}
        return null;
    }

	
	

}
