package pageObjects.jquery.uploadFile;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.jquery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage{

WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void uploadFiles(WebDriver driver, String...fileNames) {
	
		uploadFilesBySendKey(driver,HomePageUI.INPUT_FILE,  fileNames);
	}
	
}
