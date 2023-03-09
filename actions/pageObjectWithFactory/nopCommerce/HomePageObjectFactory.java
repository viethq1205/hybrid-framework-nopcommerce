package pageObjectWithFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

// pageobjectwithfactory nó khác với pageobject thường ở chỗ nó sẽ gộp chung pageobject với pageUi vào 1 class luôn
// bằng cách dùng findby, findbys, findall (dùng webelement nhé), thằng @findby này nó thay thế cho find element và by.xpath css gì gì đó nên cách build theo page factory cũng khá tiện
// nhưng thực tế khi dự án càng lúc càng phình to ra, số lượng test, element ... càng nhiều thêm thì dùng cách này sẽ gặp những vấn đề lớn trong quản lý
public class HomePageObjectFactory extends BasePageFactory {
	private WebDriver driver;

	public HomePageObjectFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pageUI
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[@class='ico-login']") // này cũng là 1 cách truyền tham số vào findby nhưng khác với cách ở trên
	private WebElement loginLink;

	@FindBy(css = "a[class='ico-account']")
	private WebElement myAccountLink;

	// pageObject/ Action
	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink); // thằng này khác với pageobject thường là chuyền thẳng cái webelement đã tạo ở trên kia vào
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}
}
