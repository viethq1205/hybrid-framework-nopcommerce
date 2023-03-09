package pageObjects.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.sauceLab.ProductsPageUI;

public class ProductsPageObject extends BasePage {
	WebDriver driver;

	public ProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String item) {
		waitForElementClickable(driver, ProductsPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductsPageUI.PRODUCT_CONTAINER_DROPDOWN, item);
	}

	public boolean isProductNameSortByAsc() {
		// khai báo arraylist để chứa các product name trên UI
		ArrayList<String> productNameList = new ArrayList<String>();

		// lấy hết ra tất cả các product name
		List<WebElement> productName = getListWebElement(driver, ProductsPageUI.PRODUCT_NAME_LIST); // ở đây cái productName get đc 6 cái tên product trên web

		// dùng vòng lặp để get text và nhét vào cái array list trên
		for (WebElement product : productName) {
			productNameList.add(product.getText());
		}

		// tạo ra 1 array list mới để sort dữ liệu
		ArrayList<String> productSortList = new ArrayList<>();
		for (String product2 : productNameList) {
			productSortList.add(product2);
		}

		// sort cái productSortList
		Collections.sort(productSortList);

		// rồi so sánh cái list này và list trên bằng nhau là verify xong
		return productSortList.equals(productNameList);
	}

	public boolean isProductNameSortByAscLambda() { // cách sort khác viết theo lambda
		List<WebElement> elementLists = getListWebElement(driver, ProductsPageUI.PRODUCT_NAME_LIST);
		List<String> names = elementLists.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);

		return names.equals(sortedNames);
	}

	public boolean isProductNameSortByDesc() {
		// khai báo arraylist để chứa các product name trên UI
		ArrayList<String> productNameList = new ArrayList<String>();

		// lấy hết ra tất cả các product name
		List<WebElement> productName = getListWebElement(driver, ProductsPageUI.PRODUCT_NAME_LIST); // ở đây cái productName get đc 6 cái tên product trên web

		// dùng vòng lặp để get text và nhét vào cái array list trên
		for (WebElement product : productName) {
			productNameList.add(product.getText());
		}

		// tạo ra 1 array list mới để sort dữ liệu
		ArrayList<String> productSortList = new ArrayList<>();
		for (String product2 : productNameList) {
			productSortList.add(product2);
		}

		// sort cái productSortList
		Collections.sort(productSortList);

		// rồi reverse cái productSortList thì ra desc
		Collections.reverse(productSortList);

		// so sánh 2 cái list đã bằng nhau chưa
		return productSortList.equals(productNameList);
	}

	public boolean isProductNameSortByDescLambda() { // cách sort khác viết theo lambda
		List<WebElement> elementLists = getListWebElement(driver, ProductsPageUI.PRODUCT_NAME_LIST);
		List<String> names = elementLists.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		Collections.reverse(sortedNames);
		return names.equals(sortedNames);
	}

	// chú ý sort thằng giá - vì nó là số khác với con chữ nên ví dụ như 15>7 nhưng code nó lại xếp thành 7>15 vì ở đây code nó đang xếp theo mỗi số 7 và số 1 chứ nó ko bao gồm 15
	public boolean isProductPriceSortByAsc() {
		ArrayList<Float> productPriceList = new ArrayList<Float>();

		List<WebElement> productPrice = getListWebElement(driver, ProductsPageUI.PRODUCT_PRICE_LIST);

		for (WebElement product : productPrice) {

			productPriceList.add(Float.parseFloat(product.getText().replace("$", "")));
		}

		ArrayList<Float> productSortList = new ArrayList<>();
		for (Float product2 : productPriceList) {
			productSortList.add(product2);
		}

		Collections.sort(productSortList);

		return productSortList.equals(productPriceList);
	}

	public boolean isProductPriceSortByDesc() {
		ArrayList<Float> productPriceList = new ArrayList<Float>();

		List<WebElement> productPrice = getListWebElement(driver, ProductsPageUI.PRODUCT_PRICE_LIST);

		for (WebElement product : productPrice) {

			productPriceList.add(Float.parseFloat(product.getText().replace("$", "")));
		}

		ArrayList<Float> productSortList = new ArrayList<>();
		for (Float product2 : productPriceList) {
			productSortList.add(product2);
		}

		Collections.sort(productSortList);

		Collections.reverse(productSortList);

		return productSortList.equals(productPriceList);
	}

}
