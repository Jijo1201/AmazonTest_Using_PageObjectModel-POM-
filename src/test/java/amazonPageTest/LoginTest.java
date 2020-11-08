package amazonPageTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import amazonPages.LoginPage;
import resources.Base;
import resources.ReadData;

public class LoginTest extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void logout() {
		driver.close();
	}

	@Test(priority = 1)
	public void invalidLoginTest() throws Exception {
		String email = ReadData.getCellData(0, 0);
		String pass = ReadData.getCellData(0, 1);
		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		login.enterUserName(email);
		login.clickContinue();
		login.enterPassword(pass);
		login.clickLogin();
		String actual = driver.findElement(By.xpath("//span[text()[normalize-space()='Your password is incorrect']]"))
				.getText();
		Assert.assertEquals(actual, "Your password is incorrect");

	}

	@Test(priority = 2)
	public void validLoginTest() throws Exception {
		String email = ReadData.getCellData(1, 0);
		String pass = ReadData.getCellData(1, 1);
		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		login.enterUserName(email);
		login.clickContinue();
		login.enterPassword(pass);
		login.clickLogin();
		String actual = driver.findElement(By.xpath("(//span[@class='nav-line-1'])[2]")).getText();
		Assert.assertEquals(actual, "Hello, USER");
	}
}
