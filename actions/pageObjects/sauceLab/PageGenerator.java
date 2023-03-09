package pageObjects.sauceLab;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static ProductsPageObject getProductsPageObject(WebDriver driver) {
		return new ProductsPageObject(driver);
	}
}
