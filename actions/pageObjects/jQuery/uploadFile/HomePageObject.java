package pageObjects.jQuery.uploadFile;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		// vì việc nhấn vào start có thể chia thành 2 chức năng: 1. nhấn 1 lần khi chỉ up 1 file và 2. nhấn nhiều lần cho nhiều file nên ta sẽ viết như dưới
		List<WebElement> startButton = getListWebElement(driver, HomePageUI.START_BUTTON);

		for (WebElement button : startButton) {
			button.click();
			sleepInSecond(1);
		}
	}

	public boolean isFileLinkUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	public boolean isImageUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.IMAGE_OF_FILE_UPLOADED, fileName);
		return isImageLoaded(driver, HomePageUI.IMAGE_OF_FILE_UPLOADED, fileName);
	}
}
