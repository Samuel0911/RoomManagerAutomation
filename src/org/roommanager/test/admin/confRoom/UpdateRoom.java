package org.roommanager.test.admin.confRoom;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.roommanager.pages.admin.confRoom.ConfRoomPage;
import org.roommanager.pages.admin.confRoom.RoomInfoPage;
import org.roommanager.pages.admin.login.LoginPage;
import org.roommanager.pages.admin.mainMenu.MainMenuPage;
import org.roommanager.utils.BrowserManager;
import org.roommanager.utils.PropertyReader;

public class UpdateRoom {
	private WebDriver driver;
	private String baseUrl;
	private String nameRoomAssert = "SM-Room Updated";
	public PropertyReader referencia = new PropertyReader();

	@BeforeTest
	public void setUp() throws Exception {
				
		driver = BrowserManager.browserChrome();
		driver.get(PropertyReader.getUrl());
	}
	
	@Test
	public void testUpdateRooms() throws Exception {
		
		driver.get(PropertyReader.getUrl());	    
		LoginPage login = new LoginPage(driver);	    
		login.setUsername(PropertyReader.getUserName());	    
		login.setPassword(PropertyReader.getPassword());	    

		MainMenuPage menu = login.clickSignInButton();	    
		
		ConfRoomPage rooms = menu.confRoomHyperLink();		
		ConfRoomPage confRoom = rooms.confRoomHyperLink();
		
			RoomInfoPage roomInfo = confRoom.doubleClickRoom();
			roomInfo.nameRoom();
			roomInfo.codeText();
			roomInfo.capacityText();
			
		confRoom = roomInfo.saveButtonForm();
					
		Assert.assertEquals(nameRoomAssert, roomInfo.getRoomName(nameRoomAssert).trim());	     
	}	

	@AfterTest
	public void tearDown() throws Exception {
		driver.get(PropertyReader.getUrl());	    
		
		LoginPage login = new LoginPage(driver);	    
		login.setUsername(PropertyReader.getUserName());	    
		login.setPassword(PropertyReader.getPassword());	    

		MainMenuPage menu = login.clickSignInButton();	    
		
		ConfRoomPage rooms = menu.confRoomHyperLink();	
		ConfRoomPage confRoom = rooms.confRoomHyperLink();
		
		RoomInfoPage roomInfo = confRoom.doubleClickRoom();
		roomInfo.nameRoomOriginal();
		
	confRoom = roomInfo.saveButtonForm();
	}

}
