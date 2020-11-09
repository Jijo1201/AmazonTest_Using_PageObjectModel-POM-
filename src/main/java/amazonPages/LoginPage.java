package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	@FindBy(id = "nav-link-accountList")
	private WebElement login;
	@FindBy(id = "ap_email")
	private WebElement emailid;
	@FindBy(id = "continue")
	private WebElement continuebtn;
	@FindBy(id = "ap_password")
	private WebElement password;
	@FindBy(id = "signInSubmit")
	private WebElement loginbtn;
	@FindBy(xpath = "(//span[@class='nav-line-1'])[2]")
	private WebElement actual;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickSignIn() {
		login.click();
	}

	public void enterUserName(String user) {
		emailid.sendKeys(user);
	}

	public void clickContinue() {
		continuebtn.click();
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		loginbtn.click();
	}

	public String actual() {

		return actual.getText();
	}

}
