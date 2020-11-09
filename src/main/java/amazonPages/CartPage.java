package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public WebDriver driver;
	@FindBy(id = "add-to-cart-button")
	private WebElement addToCart;
	@FindBy(id = "nav-cart-count")
	private WebElement clickOnCart;
	@FindBy(className = "a-dropdown-label")
	private WebElement clickOnQuantity;
	@FindBy(id = "dropdown1_2")
	private WebElement addQuantity;
	@FindBy(name = "proceedToRetailCheckout")
	private WebElement proceedToCheckout;
	@FindBy(xpath = "//input[@data-action='delete']")
	private WebElement deleteFromCart;

	public CartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addToCart() {
		addToCart.click();
	}

	public void clickOnCart() {
		clickOnCart.click();
	}

	public void clickOnQuantity() {
		clickOnQuantity.click();
	}

	public void addQuantity() {
		addQuantity.click();
	}

	public void proceedToCheckout() {
		proceedToCheckout.click();
	}

	public void deleteFromCart() {
		deleteFromCart.click();

	}

}
