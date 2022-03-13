package pageObjects.jquery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public boolean isDisplayUploadFile(WebDriver driver, String...fileNames) {
		waitForAllElementVisible(driver, HomePageUI.DISPLAY_NAME_FILE);
		List<WebElement> listFileNameUploads = getWebElements(driver, HomePageUI.DISPLAY_NAME_FILE);
		boolean isDisplay = true;                                     
		for (WebElement fileName : listFileNameUploads) {
			for (String file : fileNames) {
				if(file.equals(fileName.getText())) {
					isDisplay = true;
					break;
				}else {
					isDisplay = false;
				}
			}
		}
		System.out.println("isDisplay "+ isDisplay);
		return isDisplay;
		
	}
	
	public void startProcessUpload(WebDriver driver) {
		waitForAllElementVisible(driver, HomePageUI.START_FILE_BUTTON);
		List<WebElement> starts = getWebElements(driver, HomePageUI.START_FILE_BUTTON);
		for (WebElement start : starts) {
			clickToElementByWebElement(driver, start);
		}
	}
	
	public boolean isDisplayLinkUploadFile(WebDriver driver, String...fileNames) {
		waitForAllElementVisible(driver, HomePageUI.DISPLAY_LINK_FILE);
		List<WebElement> listFileNameUploads = getWebElements(driver, HomePageUI.DISPLAY_LINK_FILE);
		boolean isDisplay = true;                                     
		for (WebElement fileName : listFileNameUploads) {
			for (String file : fileNames) {
				if(file.equals(fileName.getText())) {
					isDisplay = true;
					break;
				}else {
					isDisplay = false;
				}
			}
		}
		System.out.println("isDisplay "+ isDisplay);
		return isDisplay;
		
	}
	
	public boolean isDispayLoadedImage(WebDriver driver, String...fileNames) {
		boolean isDisplay = true;
		for (String fileName : fileNames) {
			isDisplay = isImageLoaded(driver, HomePageUI.LOADED_IMAGE_FILE, fileName);
		}
		System.out.println("isDisplay image "+ isDisplay);
		return isDisplay;
	}
	
}
