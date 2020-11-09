package amazonPageTest;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import amazonPages.AddToCart;
import amazonPages.CartPage;
import amazonPages.HamburgerMenuOption;
import amazonPages.LoginPage;
import amazonPages.ProductFilters;
import resources.Base;
import resources.ReadData;

public class AddToCartTest extends Base {

	LoginPage login;
	HamburgerMenuOption option;
	ProductFilters filter;
	AddToCart addCart;
	CartPage cart;

	@BeforeClass
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void addToCartTest() throws Exception {
		String email = ReadData.getCellData(1, 0);
		String password = ReadData.getCellData(1, 1);
		// Login
		login = new LoginPage(driver);
		login.clickSignIn();
		login.enterUserName(email);
		login.clickContinue();
		login.enterPassword(password);
		login.clickLogin();
		String expected = "Hello, Jijo";
		String actual = login.actual();
		Assert.assertEquals(actual, expected);
		// HamburgerOptions
		option = new HamburgerMenuOption(driver);
		option.clickOnHamburgerIcon();
		option.selectMobileDropDown();
		option.selectAccessories();
		// FilterOptions
		filter = new ProductFilters(driver);
		filter.selectHeadphones();
		filter.selectWiredAndWireless();
		driver.wait(2000);
		// Select Product
		addCart = new AddToCart(driver);
		addCart.headPhoneSelect();
		driver.wait(2000);
		String actualHeadset = addCart.actual();
		String expectedHeadset = "boAt Rockerz 255 Sports in-Ear Bluetooth Neckband Earphone with Mic (Active Black)";
		Assert.assertEquals(actualHeadset, expectedHeadset);
		ArrayList<String> e = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(e.get(1));
		// Add to cart
		cart = new CartPage(driver);
		cart.addToCart();
		Assert.assertTrue(true);
		cart.clickOnCart();
		cart.clickOnQuantity();
		cart.addQuantity();
		Assert.assertTrue(true);

	}

	@AfterClass
	public void teardown() {

		driver.close();
		driver.quit();
	}
}
