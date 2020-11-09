package amazonPageTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import amazonPages.CartPage;
import amazonPages.LoginPage;
import resources.Base;
import resources.ReadData;

public class RemoveFromCartTest extends Base {

	LoginPage login;
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
		cart = new CartPage(driver);
		cart.clickOnCart();
		cart.deleteFromCart();
		Assert.assertTrue(true);

	}

	@AfterClass
	public void teardown() {

		driver.close();
	}
}
