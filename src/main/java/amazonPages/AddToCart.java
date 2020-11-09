package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	public WebDriver driver;

	@FindBy(xpath = "//span[text()='boAt Rockerz 255 Sports in-Ear Bluetooth Neckband Earphone with Mic (Active Black)']")
	private WebElement headPhoneSelect;
	@FindBy(xpath = "//span[text()[normalize-space()='boAt Rockerz 255 Sports in-Ear Bluetooth Neckband Earphone with Mic (Active Black)']]")
	private WebElement actual;

	public AddToCart(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void headPhoneSelect() {
		headPhoneSelect.click();
	}

	public String actual() {
		return actual.getText();
	}

}
