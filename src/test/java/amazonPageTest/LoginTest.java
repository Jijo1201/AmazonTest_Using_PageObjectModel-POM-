package amazonPageTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import amazonPages.LoginPage;
import resources.Base;
import resources.ReadData;

public class LoginTest extends Base {

	String inputFilename = "./" + "\\src\\main\\java\\resources\\Data.xlsx";
	String sheetname = "login";

	@BeforeClass
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider = "userdata")
	public void toLogin(String username, String password) throws InterruptedException {

		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		login.enterUserName(username);
		login.clickContinue();
		login.enterPassword(password);
		login.clickLogin();
		if (driver.findElement(By.cssSelector("div#auth-error-message-box>div>i")).isDisplayed() == true) {
			driver.findElement(By.xpath("//i[@class='a-icon a-icon-logo']")).click();
		} else {
			driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.findElement(By.xpath("//i[@class='a-icon a-icon-logo']")).click();
		}

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

	@DataProvider(name = "userdata")
	public String[][] getData() throws IOException {
		int rowcount = ReadData.getRowCount(inputFilename, sheetname);
		int cellcount = ReadData.getCellData(inputFilename, sheetname, 0);
		String loginData[][] = new String[rowcount][cellcount];

		for (int row = 1; row <= rowcount; row++) {

			for (int cell = 0; cell < cellcount; cell++) {

				loginData[row - 1][cell] = ReadData.getCellData(inputFilename, sheetname, row, cell);

			}
		}
		return loginData;

	}
}
