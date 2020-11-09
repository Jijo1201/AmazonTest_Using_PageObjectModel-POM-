package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductFilters {
	public WebDriver driver;

	@FindBy(xpath = "//span[text()='Headphones & Earbuds']")
	private WebElement selectHeadphones;

	@FindBy(xpath = "//span[text()='Wired & Wireless']")
	private WebElement selectWiredAndWireless;

	public ProductFilters(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectHeadphones() {
		selectHeadphones.click();
	}

	public void selectWiredAndWireless() {
		selectWiredAndWireless.click();
	}
}
