package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenuOption {
	public WebDriver driver;

	@FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
	private WebElement hamburgerIcon;
	@FindBy(xpath = "//a[@data-menu-id='8']")
	private WebElement mobileDropDown;
	@FindBy(linkText = "All Mobile Accessories")
	private WebElement selectAccessories;

	public HamburgerMenuOption(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnHamburgerIcon() {
		hamburgerIcon.click();
	}

	public void selectMobileDropDown() {
		mobileDropDown.click();
	}

	public void selectAccessories() {
		selectAccessories.click();
	}

}
